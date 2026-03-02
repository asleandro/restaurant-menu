package com.leandro.restaurant_menu.controller;

import com.leandro.restaurant_menu.dto.request.MenuItemRequest;
import com.leandro.restaurant_menu.dto.response.MenuItemResponse;
import com.leandro.restaurant_menu.entity.MenuItem;
import com.leandro.restaurant_menu.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItem> getAll(){
        List<MenuItem> menuItemList = menuItemService.getAll();

        return menuItemList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItemResponse save(@RequestBody @Valid MenuItemRequest request){
        return menuItemService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        menuItemService.deleteById(id);
    }


}
