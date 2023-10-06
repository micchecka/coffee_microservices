package com.user.controller;

import com.user.dto.DTO;
import com.user.menu_service.MenuService;
import com.user.domain.Item;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("api/v1/menu")
public class Controller {
    private final MenuService menuService;



    @GetMapping
    public ResponseEntity<List<Item>> getItems(){
//     List<Item> itemList = menuService.getAllItems();
//     return ResponseEntity.ok(menuService.convertToDTO(itemList));
       // restTemplate.postForEntity(callback,menuService.convertToDTO(itemList), Void.class;
        return ResponseEntity.ok(menuService.getAllItems());
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DTO>> getDTOs(){
     List<Item> itemList = menuService.getAllItems();
     return ResponseEntity.ok(menuService.convertToDTO(itemList));

    }
}
