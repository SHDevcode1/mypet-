package com.app.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Products  {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	//private String product_name;
	private String product_description;
	private int product_upc;
	//private int product_price;
	//private long id_pet;
	//private long id_category;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getProduct_upc() {
		return product_upc;
	}
	public void setProduct_upc(int product_upc) {
		this.product_upc = product_upc;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", product_description=" + product_description + ", product_upc=" + product_upc
				+ "]";
	}
	public Products(long id, String product_description, int product_upc) {
		super();
		this.id = id;
		this.product_description = product_description;
		this.product_upc = product_upc;
	}
	
	
	
}
