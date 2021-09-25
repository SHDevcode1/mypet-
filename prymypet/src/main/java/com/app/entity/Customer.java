package com.app.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	
	private long id;
	private String firstName;
	private String lastName;
	private String identification;
	private String email;
	private String numberContact;
	private String address;
	private String city;

	public Customer() {}
	
	public Customer(long id, String firstName, String lastName, String identification, String email, String numberContact, String address, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identification = identification;
		this.email = email;
		this.numberContact = numberContact;
		this.address = address;
		this.city = city;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) &&
			Objects.equals(firstName, customer.firstName) &&
			Objects.equals(lastName, customer.lastName) &&
			Objects.equals(identification, customer.identification) &&
			Objects.equals(email, customer.email) &&
			Objects.equals(numberContact, customer.numberContact) &&
			Objects.equals(address, customer.address) &&
			Objects.equals(city, customer.city);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, identification, email, numberContact, address, city);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumberContact() {
		return numberContact;
	}
	public void setNumberContact(String numberContact) {
		this.numberContact = numberContact;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
	
	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\''+
				", lastName='" + lastName + '\''+
				", identification='" + identification + '\''+
				", email='" + email + '\''+
				", numberContact='" + numberContact + '\''+
				", address='" + address + '\''+
				", city='" + city + '\''+
				'}';
				
	}
}
