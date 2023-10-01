package com.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.net.URL;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends Item {
    private String coffee_name;
    private String coffee_description;
    private Integer coffee_price;
//    @ManyToMany
//    private Set<Tag> tags;
    private URL coffee_image;
}
