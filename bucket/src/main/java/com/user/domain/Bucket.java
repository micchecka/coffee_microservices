package com.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Bucket implements Serializable {

    @Id
    private UUID bucketId;
    @ManyToMany
    private List<Item> itemList;

}
