package com.user.DTO;

import com.user.domain.Bucket;
import com.user.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class InitialDataResponse {
   private List<Item> itemList;
   private Bucket bucket;
}
