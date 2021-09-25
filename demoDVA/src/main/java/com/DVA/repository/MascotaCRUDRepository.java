package com.DVA.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.DVA.entity.Mascota;


@Repository
//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface MascotaCRUDRepository extends CrudRepository<Mascota, Long>{
	

}