package com.user.menu_service;

import com.user.dto.DTO;
import com.user.model.Coffee;
import com.user.model.Food;
import com.user.model.Item;
import com.user.model.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.yaml.snakeyaml.tokens.Token.ID.Tag;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;


    public List<Item> getAllItems() {
//        List<Item> items = menuRepository.findAll();
//        for (Item item : items) {
//            if (item.getClass() == Coffee.class) {
//                Coffee coffee = (Coffee) item;
//                coffee.getTags();
//            } else if (item.getClass() == Food.class) {
//                Food food = (Food) item;
//                food.getTags();
//            }
//        }
//        return items;
    return menuRepository.findAll();
    }


    public List<DTO> convetToDTO(List<Item> itemList){
       List<DTO> dtoList = new ArrayList<>();
        for (Item item: itemList ) {
            DTO dto = new DTO();
            if (item.getClass()== Coffee.class){
                Coffee coffee = (Coffee) item;
                dto.setId(coffee.getItem_id());
                dto.setName(coffee.getCoffee_name());
                dto.setDescription(coffee.getCoffee_description());
                dto.setPrice(coffee.getCoffee_price());
                dto.setTags(item.getTags().stream().map(com.user.model.Tag::getTagName).collect(Collectors.toList()));
                dtoList.add(dto);
            } else if (item.getClass() == Food.class) {
                Food food = (Food) item;
                dto.setId(food.getItem_id());
                dto.setName(food.getFood_name());
                dto.setDescription(food.getFood_description());
                dto.setPrice(food.getFood_price());
                dto.setTags(item.getTags().stream().map(com.user.model.Tag::getTagName).collect(Collectors.toList()));
                dtoList.add(dto);
            }
        }
      return dtoList;
    }
}
