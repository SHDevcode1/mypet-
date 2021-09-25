package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Productss {
	
	 private List<Products> ProductsList;
	 public List<Products> getProductsList() {
	        if(ProductsList == null) {
	        	ProductsList = new ArrayList<>();
	        }
	        return ProductsList;
	    }
	 
	    public void setEmployeeList(List<Products> ProductsList) {
	        this.ProductsList = ProductsList;
	    }
	 
}
