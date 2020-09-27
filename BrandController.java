package com.example.productcatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productcatalogservice.model.Brand;
import com.example.productcatalogservice.service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
@GetMapping
public List<Brand> findAll()
{
	return brandService.findAll();
}

}
