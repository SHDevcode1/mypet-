package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Fundacion;

@Repository
public interface FundacionCRUDRepository extends CrudRepository<Fundacion, Long>{
	

}
