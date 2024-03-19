package com.other.spring_fast.chapter_8.http_methods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
//	@RequestMapping("/products")
	@GetMapping("/products")
	public String viewProducts(Model model) {
		List<Product> products = productService.finfAll();
		model.addAttribute("products", products);
		return "products.html";
	}
	
//	@RequestMapping(path = "/products", method = RequestMethod.POST)
	@PostMapping("/products")
	public String addProduct(/*@RequestParam String name, @RequestParam double price*/Product product, Model model)  {
//		Product product = new Product();
//		product.setName(name);
//		product.setPrice(price);
		productService.addProduct(product);
		List<Product> products = productService.finfAll();
		model.addAttribute("products", products);
		return "products.html";
	}
}
