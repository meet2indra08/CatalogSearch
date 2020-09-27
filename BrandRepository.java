package com.example.productcatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productcatalogservice.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
