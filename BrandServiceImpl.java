package com.example.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productcatalogservice.model.Brand;
import com.example.productcatalogservice.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandRepository brandRepository;

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

}
