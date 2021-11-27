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

import com.app.entity.Fundacion;
import com.app.entity.Fundacions;
import com.app.repository.FundacionCRUDRepository;
import com.app.repository.FundacionQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RequestMapping("/api/fundacionCustomAPI")
public class FundacionController 
{
	@Autowired
    private FundacionCRUDRepository fundacionRepository;
	@Autowired
	private FundacionQUERYRepository fundacionRepositoryQuery;


	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addfundacion", consumes = "application/json", produces = "application/json")
	public Fundacion addNewFundacionApi(@RequestBody Fundacion fundacion) {
        //add resource
     	fundacion = fundacionRepository.save(fundacion);
		return fundacion;
	}
    
	@CrossOrigin(origins = "*")
    @GetMapping(path= "/fundaciongetall", produces = "application/json")
    public Fundacions getAllFundacionsApi() 
    {
		Fundacions response = new Fundacions();
		ArrayList<Fundacion> list = new ArrayList<>();
		fundacionRepository.findAll().forEach(e -> list.add(e));
		response.setFundacionList(list);
        return response;
    }
       
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updatefundacion", consumes = "application/json", produces = "application/json")
	public Fundacion updateFundacion(@RequestBody Fundacion fundacion) {
        //add resource
     	fundacionRepository.save(fundacion);
		return fundacion;
	}
    //***Api Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/fundacionremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteFundacionApi(@RequestBody Fundacion employe) {
		fundacionRepository.deleteById(employe.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
    
      	
	/* Otras Formas  pero Bajo jUnit Testing*/
	@GetMapping(path="/fundacions", produces = "application/json")
    public Fundacions getFundacions() 
    {
		Fundacions response = new Fundacions();
		ArrayList<Fundacion> list = new ArrayList<>();
		fundacionRepository.findAll().forEach(e -> list.add(e));
		response.setFundacionList(list);
        return response;
    }
    
    @PostMapping(path= "/fundacions", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addFundacion(@RequestBody Fundacion fundacion) {       
        //add resource
    	fundacion = fundacionRepository.save(fundacion);
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(fundacion.getId())
                                    .toUri();
        //Send location in response
        return ResponseEntity.created(location).build();
    }
      
    
    
}

