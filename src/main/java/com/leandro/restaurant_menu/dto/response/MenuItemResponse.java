package com.leandro.restaurant_menu.dto.response;

import com.leandro.restaurant_menu.entity.MenuItem;

import java.math.BigDecimal;

public record MenuItemResponse(Long id,
                               String name,
                               String image,
                               BigDecimal price) {

    public static MenuItemResponse fromEntity(MenuItem entity) {
        return new MenuItemResponse(
                entity.getId(),
                entity.getName(),
                entity.getImage(),
                entity.getPrice()
        );
    }
}
