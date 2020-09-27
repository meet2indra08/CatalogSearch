package com.example.productcatalogservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("products")
public class Color implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private String code;
	public Color() {
		super();
	}
	
	@OneToMany(mappedBy = "color", fetch = FetchType.EAGER)
	private Set<Product> products;

	
	public Long getId() {
		return id;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
