package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Customer;

@Repository
//@RepositoryRestResource(collectionResourceRel = "Customerr", path = "Customerr")
public interface CustomerCRUDRepository extends CrudRepository<Customer, Long>{

}
