package com.example.productcatalogservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javassist.SerialVersionUID;

@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties("products")
public class Product implements Serializable
{
private static final long serialVersionUID = 1L;
@Id
private Long id;
private String name;
private Integer quantity;
private String size;
private Integer price;
@Column(name = "BRAND_ID")
private Integer brandId;
@Column(name = "CLR_ID")
private Integer colorId;
@Column(name = "PRODUCT_CAT_ID")
private Integer productCatId;

//@JsonIgnoreProperties("Products")
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(insertable = false,updatable = false, name = "BRAND_ID")
private Brand brand;

//@JsonIgnoreProperties("Products")
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(insertable = false, updatable = false, name = "CLR_ID")
private Color color;

//@JsonIgnoreProperties("Products")
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(insertable = false, updatable = false,name = "PRODUCT_CAT_ID")
private Productcat productcat;

public Product() {
	super();
	// TODO Auto-generated constructor stub
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

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}


public Integer getBrandId() {
	return brandId;
}

public void setBrandId(Integer brandId) {
	this.brandId = brandId;
}



public Integer getColorId() {
	return colorId;
}

public void setColorId(Integer colorId) {
	this.colorId = colorId;
}

public Integer getProductCatId() {
	return productCatId;
}

public void setProductCatId(Integer productCatId) {
	this.productCatId = productCatId;
}

public Brand getBrand() {
	return brand;
}

public void setBrand(Brand brand) {
	this.brand = brand;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public Productcat getProductcat() {
	return productcat;
}

public void setProductcat(Productcat productcat) {
	this.productcat = productcat;
}




}
