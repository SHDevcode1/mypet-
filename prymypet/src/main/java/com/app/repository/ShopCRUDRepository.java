package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Shop;
 
@Repository
@RepositoryRestResource(collectionResourceRel = "Shop", path = "shop")
public interface ShopCRUDRepository extends CrudRepository<Shop, Long>{
	

}