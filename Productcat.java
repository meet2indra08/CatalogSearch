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
public class Productcat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;

	@OneToMany(mappedBy = "productcat", fetch = FetchType.EAGER)
	private Set<Product> products;
	
	public Productcat() {
		super();
	}
	
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
	public Long getId() {
		return id;
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
	
	
	
	

}
