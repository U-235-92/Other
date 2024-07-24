package com.other.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.other.app.dto.ItemDTO;
import com.other.app.dto.ItemHolderDTO;
import com.other.app.entity.Item;
import com.other.app.entity.ItemHolder;
import com.other.app.service.AppService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class AppController {

	private final AppService service;
	
	@PostMapping("/add_item")
	@ResponseBody
	public String addItem(@RequestBody ItemDTO itemDTO) {
		service.addItem(itemDTO);
		return "Item added success!";
	}
	
	@GetMapping("/get_items")
	@ResponseBody
	public List<Item> getItems() {
		return service.getItems();
	}
	
	@PostMapping("/add_item_holder")
	@ResponseBody
	public String addItemHolder(@RequestBody ItemHolderDTO itemHolderDTO) {
		service.addItemHolder(itemHolderDTO);
		return "Item_holder added success!";
	}
	
	@GetMapping("/get_item_holders")
	@ResponseBody
	public List<ItemHolder> getItemHolders() {
		return service.getItemHolders();
	}
}
