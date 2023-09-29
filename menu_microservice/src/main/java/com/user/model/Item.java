package com.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {
    @Id
    @SequenceGenerator(
            name = "item_id_sequence",
            sequenceName = "item_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )
    private Integer item_id;

    @ManyToMany(mappedBy = "items")
    @JsonManagedReference
    private Set<Tag> tags = new HashSet<>();

}
