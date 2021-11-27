package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Fundacion;

public interface FundacionQUERYRepository extends PagingAndSortingRepository<Fundacion, Long>{
	/*List<Fundacion> findByFirstName(@Param("fun_name") String fun_name);*/
}

