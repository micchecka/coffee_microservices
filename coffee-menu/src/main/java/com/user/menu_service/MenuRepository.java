package com.user.menu_service;

import com.user.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Item, Integer> {
//    @Override
//    @EntityGraph(attributePaths = "tags")
//    List<Item> findAll();

}
