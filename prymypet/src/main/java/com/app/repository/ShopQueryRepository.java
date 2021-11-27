package com.app.repository;
 
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Shop;

@RepositoryRestResource(collectionResourceRel = "shop", path = "shop")
public interface ShopQueryRepository extends PagingAndSortingRepository<Shop, Long>{
//	List<Shop> findByFirstName(@Param("name") String name);
 }