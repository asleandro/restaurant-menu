package com.leandro.restaurant_menu.service;

import com.leandro.restaurant_menu.dto.request.MenuItemRequest;
import com.leandro.restaurant_menu.dto.response.MenuItemResponse;
import com.leandro.restaurant_menu.entity.MenuItem;
import com.leandro.restaurant_menu.exception.BusinessException;
import com.leandro.restaurant_menu.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItemResponse update(Long id, MenuItemRequest request) {
        MenuItem actualMenuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de menu não encontrado com ID: " + id));

        MenuItem updatedEntity = updateMenuItem(actualMenuItem, request);
        MenuItem savedEntity = menuItemRepository.save(updatedEntity);

        return MenuItemResponse.fromEntity(savedEntity);
    }

    private MenuItem updateMenuItem(MenuItem entity, MenuItemRequest request) {
        if (request.name() != null) {
            entity.setName(request.name());
            System.out.println("Nome atualizado para: " + request.name());
        }
        if (request.image() != null) {
            entity.setImage(request.image());
            System.out.println("Imagem atualizada");
        }
        if (request.price() != null) {
            entity.setPrice(request.price());
            System.out.println("Preço atualizado para: " + request.price());
        }
        return entity;
    }

    public List<MenuItem> getAll() {
        return menuItemRepository.findAll();
    }

    public MenuItemResponse save(MenuItemRequest request) {
        if (request.name() == null) {
            throw new BusinessException("Campo nome não pode estar vazio"
            );
        }
        if (menuItemRepository.existsByNameIgnoreCase(request.name())) {
            throw new BusinessException(
                    "name",
                    "Já existe um item cadastrado com o nome: " + request.name()
            );
        }

        MenuItem entity = new MenuItem();

        entity.setName(request.name());
        entity.setImage(request.image());
        entity.setPrice(request.price());

        MenuItem savedEntity = menuItemRepository.save(entity);

        return MenuItemResponse.fromEntity(savedEntity);

    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }
}
