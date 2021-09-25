package com.app.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Products;
@Repository
public interface ProductsCRUDRepository extends CrudRepository<Products, Long> {
	
}
