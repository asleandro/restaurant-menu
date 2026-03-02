package com.leandro.restaurant_menu.repository;

import com.leandro.restaurant_menu.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    boolean existsByNameIgnoreCase(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
