package com.app.entity;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
 
@Entity
public class Shop {
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long nit;
	private String shop_name;
	private String city;
	private String ubication;
	public Long getNit() {
		return nit;
	}
	public void setNit(Long nit) {
		this.nit = nit;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUbication() {
		return ubication;
	}
	public void setUbication(String ubication) {
		this.ubication = ubication;
	}
	@Override
	public String toString() {
		return "Shop [nit=" + nit + ", shop_name=" + shop_name + ", city=" + city + ", ubication=" + ubication + "]";
	}
	
	public Shop(long nit, String shop_name, String city, String ubication) {
		// TODO Auto-generated constructor stub
	}
	

	
}
