package com.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bucket {


    private UUID bucketId;

    private List<Item> itemList;


}