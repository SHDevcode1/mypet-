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

import com.app.entity.Customer;
import com.app.entity.Customerr;
import com.app.repository.CustomerCRUDRepository;
import com.app.repository.CustomerQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https://www.baeldung.com/spring-cors
@RequestMapping("/api/customerCustomAPI")

public class CustomerController 
{
	@Autowired
    private CustomerCRUDRepository customerRepository;
	@Autowired
	private CustomerQUERYRepository customerRepositoryQuery;


    //***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addcustomer", consumes = "application/json", produces = "application/json")
	public Customer addNewCustomerApi(@RequestBody Customer customer) {
        //add resource
     	customer = customerRepository.save(customer);
		return customer;
	}
    
    //***Api Final Para FRONT
	@CrossOrigin(origins = "*")
    @GetMapping(path= "/customergetall", produces = "application/json")
    public Customerr getAllCustomerrApi() 
    {
		Customerr response = new Customerr();
		ArrayList<Customer> list = new ArrayList<>();
		customerRepository.findAll().forEach(e -> list.add(e));
		response.setCustomerList(list);
        return response;
    }
       
    //***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updatecustomer", consumes = "application/json", produces = "application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
        //add resource
     	customerRepository.save(customer);
		return customer;
	}
    //***Api Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/customerremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteCustomerApi(@RequestBody Customer customer) {
		customerRepository.deleteById(customer.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
      
    
    
}
