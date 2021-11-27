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

import com.app.entity.Shop;
import com.app.repository.ShopCRUDRepository;
import com.app.repository.ShopQueryRepository;
import com.app.entity.ListShops;
 

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Product_ShopCustomAPI")
public class ShopController{
	@Autowired
	private ShopCRUDRepository shopRepository;
	@Autowired
	private ShopQueryRepository shopRepositoryQuery;
	
	//***Api Final Front
	@CrossOrigin(origins ="*")
	@PostMapping(path = "/addshop", consumes= "application/json", produces = "application/json")
	public Shop addNewProduct_ShopApi(@RequestBody Shop shop) {
		//add source
		shop = shopRepository.save(shop);
			return shop;
	}
	
    //***Api Final Para FRONT
	@CrossOrigin(origins = "*")
    @GetMapping(path= "/shopgetall", produces = "application/json")
    public ListShops getAllShopApi() 
    {
		ListShops response = new ListShops();
		ArrayList<Shop> list = new ArrayList<>();
		shopRepository.findAll().forEach(e -> list.add(e));
		response.setShopList(list);
        return response;
    }
	//***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updateshop", consumes = "application/json", produces = "application/json")
	public Shop updateShop(@RequestBody Shop shop) {
        //add resource
     	shopRepository.save(shop);
		return shop;
	}
	//***Api Final Front
		@CrossOrigin(origins = "*")
		@PostMapping(path = "/shopremove", consumes = "application/json")
		public @ResponseBody ResponseEntity<String> deleteShopApi(@RequestBody Shop shop) {
			shopRepository.deleteById(shop.getNit());
			return new ResponseEntity<String>(HttpStatus.OK);
		}

	
} 
