package com.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data

public class DTO {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private List<String> tags;


}
