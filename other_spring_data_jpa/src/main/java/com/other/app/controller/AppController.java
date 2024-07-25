package com.other.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.other.app.dto.BookDTO;
import com.other.app.dto.ItemDTO;
import com.other.app.dto.ItemHolderDTO;
import com.other.app.entity.Book;
import com.other.app.entity.Item;
import com.other.app.entity.ItemHolder;
import com.other.app.entity.Robot;
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
	
	@GetMapping("/get_books")
	@ResponseBody
	public List<Book> getBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/test_jpa_query")
	@ResponseBody
	public List<Book> testJPAQuery() {
		return service.testJPAQuery();
	}
	
	@PostMapping("/add_book")
	@ResponseBody
	public void addBook(@RequestBody BookDTO bookDTO) {
		service.addBook(bookDTO);
	}
	
	@PostMapping("/add_robot")
	public void addRobot(@RequestBody Robot robot) {
		service.addRobot(robot);
	}
	
	@GetMapping("/get_robots")
	@ResponseBody
	public List<Robot> getRobots() {
		return service.getRobots();
	}
}
