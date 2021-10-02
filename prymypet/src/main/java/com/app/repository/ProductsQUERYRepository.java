package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.app.entity.Products;
public interface ProductsQUERYRepository extends PagingAndSortingRepository<Products, Long>  {
	List<Products> findById(@Param("id") long id);
}
