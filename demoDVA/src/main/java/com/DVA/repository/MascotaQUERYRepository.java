package com.DVA.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.DVA.entity.Mascota;


public interface MascotaQUERYRepository extends PagingAndSortingRepository<Mascota, Long>{
	//List<Mascota> findByNombre_Mascota(@Param("Nombre_Mascota") String Nombre_Mascota);
}