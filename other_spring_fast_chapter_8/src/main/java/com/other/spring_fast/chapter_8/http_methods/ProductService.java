package com.other.spring_fast.chapter_8.http_methods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public List<Product> finfAll() {
		return products;
	}
}
