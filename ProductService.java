package com.example.productcatalogservice.service;

import java.util.List;

import com.example.productcatalogservice.model.Product;

public interface ProductService {

	List<Product> findAll();
	List<Product> getProducts(String groupbyvalue, String actualvalue);
	
}
