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
@AllArgsConstructor
@NoArgsConstructor
public class Food extends Item {
    private String food_name;
    private String food_description;

    private Integer food_price;
//    @ManyToMany
//    private Set<Tag> tags;
    private URL food_image;

}
