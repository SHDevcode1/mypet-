package com.app.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.entity.Products;
import com.app.entity.Productss;
import com.app.repository.ProductsCRUDRepository;
import com.app.repository.ProductsQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https://www.baeldung.com/spring-cors
@RequestMapping("/api/productsCustomAPI")
public class ProductsController {
	
	@Autowired
	private ProductsCRUDRepository crudRepository;
	@Autowired
	private ProductsQUERYRepository productsQUERYRepository;
	
	/*Obtener productos
	@CrossOrigin(origins = "*")
	@GetMapping(path= "/productsgetall", produces = "application/json")
	public Productss getProductsList(@RequestParam long id_pet) {
		Productss response = new Productss();
		ArrayList<Products> list = new ArrayList<>();
		crudRepository.findById(id_pet);
		response.setEmployeeList(list);
		return response;
	}*/
	
	//Obtener
	@CrossOrigin(origins = "*")
	@GetMapping(path= "/productsgetall", produces = "application/json")
	public Productss getProductsList() {
		Productss response = new Productss();
		ArrayList<Products> list = new ArrayList<>();
		crudRepository.findAll().forEach(e -> list.add(e));
		response.setEmployeeList(list);
		return response;
	}
	
	//Añadir
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addemployee", consumes = "application/json", produces = "application/json")
	public Products addProductsApi(@RequestBody Products products) {
        //add resource
     	products = crudRepository.save(products);
		return products;
	}
	
	//Actualizar
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updateemployee", consumes = "application/json", produces = "application/json")
	public Products updateProducts(@RequestBody Products products) {
        //add resource
     	crudRepository.save(products);
		return products;
	}
	
	//Remover
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/employeeremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteProductApi(@RequestBody Products products) {
		crudRepository.deleteById(products.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
