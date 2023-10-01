package com.user.controller;

import com.user.dto.DTO;
import com.user.menu_service.MenuService;
import com.user.domain.Item;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/menu")
public class Controller {
    private final MenuService menuService;


    @GetMapping
    public ResponseEntity<List<DTO>> getItems(){
     List<Item> itemList = menuService.getAllItems();
     return ResponseEntity.ok(menuService.convetToDTO(itemList));
    }
}
