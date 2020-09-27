package com.example.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.repository.ProductRepository;

enum GroupBy {

	BRAND("brand"), COLOR("color"), SIZE("size");
	String value;

	GroupBy(String name) {
		value = name;
	}

	String getValue() {
		return value;
	}
}

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll(); 
	}

	@Override
	public List<Product> getProducts(String groupbyvalue, String actualvalue) {
		GroupBy groupBy = GroupBy.valueOf(groupbyvalue.toUpperCase());
		switch (groupBy) {
		case BRAND:
			return productRepository.findByBrandId(Integer.valueOf(actualvalue));
		case COLOR:
			return productRepository.findByColorId(Integer.valueOf(actualvalue));
		case SIZE:
			return productRepository.findBySize(actualvalue);
		default:
			return null;
		}

	}
}
