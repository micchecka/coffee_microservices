package com.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import javax.persistence.*;

import java.net.URL;
import java.util.List;
import java.util.Set;

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
