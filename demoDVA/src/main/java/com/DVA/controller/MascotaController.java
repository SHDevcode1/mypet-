package com.DVA.controller;

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

import com.DVA.entity.Mascota;
import com.DVA.entity.Mascotas;
import com.DVA.repository.MascotaCRUDRepository;
import com.DVA.repository.MascotaQUERYRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //https://www.baeldung.com/spring-cors
@RequestMapping("/api/mascotaCustomAPI")

public class MascotaController {
	
	@Autowired
    private MascotaCRUDRepository mascotaRepository;
	@Autowired
	private MascotaQUERYRepository mascotaRepositoryQuery;


    //***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addmascota", consumes = "application/json", produces = "application/json")
	public Mascota addNewMascotaApi(@RequestBody Mascota mascota) {
        //add resource
     mascota = mascotaRepository.save(mascota);
		return mascota;
	}
    
    //***Api Final Para FRONT
	@CrossOrigin(origins = "*")
    @GetMapping(path= "/mascotasgetall", produces = "application/json")
    public Mascotas getAllMascotasApi() 
    {
		Mascotas response = new Mascotas();
		ArrayList<Mascota> list = new ArrayList<>();
		mascotaRepository.findAll().forEach(e -> list.add(e));
		response.setMascotasList(list);
	      return response;
    }
       
    //***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/updatelistarmascotas", consumes = "application/json", produces = "application/json")
	public Mascota updateMascotas(@RequestBody Mascota mascotas) {
        //add resource
     	mascotaRepository.save(mascotas);
		return mascotas;
	}
    //***Api Final Front
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/mascotasremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteMascotaApi(@RequestBody Mascota mascotas) {
		mascotaRepository.deleteById(mascotas.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
    
      	
	//*** Otras Formas  pero Bajo jUnit Testing*/
	@GetMapping(path="/mascotas", produces = "application/json")
    public Mascotas getMascotas() 
    {
		Mascotas response = new Mascotas();
		ArrayList<Mascota> list = new ArrayList<>();
		mascotaRepository.findAll().forEach(e -> list.add(e));
		response.setMascotasList(list);
        return response;
    }
    
	  @PostMapping(path= "/mascotas", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> addMascotas(@RequestBody Mascota mascotas) {       
	        //add resource
	    	mascotas = mascotaRepository.save(mascotas);
	        //Create resource location
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(mascotas.getId())
	                                    .toUri();
	        //Send location in response
	        return ResponseEntity.created(location).build();
	    }

}
