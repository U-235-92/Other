package com.other.app.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.other.app.dto.ItemDTO;
import com.other.app.dto.ItemHolderDTO;
import com.other.app.entity.Item;
import com.other.app.entity.ItemHolder;
import com.other.app.repository.ItemHolderRepository;
import com.other.app.repository.ItemRepository;

@Service
public class AppService {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemHolderRepository itemHolderRepository;
	
	public void addItem(ItemDTO itemDTO) {
		Item item = new Item();
		item.setTitle(itemDTO.getTitle());
		itemRepository.save(item);
	}
	
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
	public void addItemHolder(ItemHolderDTO itemHolderDTO) {
		Function<ItemDTO, Item> itemDTOToItem = itemDTO -> {
			Item item = new Item();
			item.setTitle(itemDTO.getTitle());
			return item;
		};
		ItemHolder order = new ItemHolder();
		order.setItems(itemHolderDTO.getItemDTOs().stream().map(itemDTOToItem).toList());
		itemHolderRepository.save(order);
	}
	
	public List<ItemHolder> getItemHolders() {
		return itemHolderRepository.findAll();
	}
}
