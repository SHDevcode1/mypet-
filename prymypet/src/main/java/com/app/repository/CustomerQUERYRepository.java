package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Customer;

//@RepositoryRestResource(collectionResourceRel = "Customerr", path = "Customerr")
public interface CustomerQUERYRepository extends PagingAndSortingRepository<Customer, Long>{
	List<Customer> findByFirstName(@Param("name") String name);
}

