package com.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

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
