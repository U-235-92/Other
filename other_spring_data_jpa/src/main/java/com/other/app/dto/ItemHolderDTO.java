package com.other.app.dto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHolderDTO {

	private List<ItemDTO> itemDTOs = new CopyOnWriteArrayList<ItemDTO>();
}
