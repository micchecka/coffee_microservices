package com.user.menu_service;

import com.user.model.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Item, Integer> {
//    @Override
//    @EntityGraph(attributePaths = "tags")
//    List<Item> findAll();

}
