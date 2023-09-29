package com.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Tag {
    @Id
    @SequenceGenerator(
            name = "tag_id_sequence",
            sequenceName = "tag_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_id_sequence"
    )
    private Integer tagId;

    private String tagName;

    @ManyToMany
    @JoinTable(
            name = "item_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    @JsonBackReference
   private Set<Item> items = new HashSet<>();
//
//    @ManyToMany
//    @JoinTable(
//            name = "food_tags",
//            joinColumns = @JoinColumn(name = "food_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    private Set<Food> foods = new HashSet<>();
}
