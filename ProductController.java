package com.example.productcatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProduct()
	{
		return productService.findAll();
	}
	
	@GetMapping("/search/{filter}/{value}")
	public List<Product> getProducts(@PathVariable String filter,
			@PathVariable String value) {
		List<Product> products = productService.getProducts(filter, value);
		if(products==null || products.isEmpty()) {}
	//		throw new B2CException("Product not found!");
		
		return products;
	}

}
