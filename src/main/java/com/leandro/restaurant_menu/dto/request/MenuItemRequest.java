package com.leandro.restaurant_menu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record MenuItemRequest(Long id,
                              @NotBlank(message = "Nome é obrigatório")
                              String name,
                              String image,
                              @Positive(message = "Valor deve ser positivo")
                              @NotNull(message = "Preço é obrigatório")
                              BigDecimal price) {
}
