package com.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DTO {

    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private List<String> tags;


}

