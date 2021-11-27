package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.controller.FundacionController;
import com.app.entity.Fundacion;
import com.app.entity.Fundacions;
import com.app.repository.FundacionCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class FundacionControllerUnitTests {
	
	@InjectMocks
	FundacionController fundacionController;

	@Mock
	FundacionCRUDRepository fundacionRepositoryMock;

	@Test
	public void testAddFundacion() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Fundacion fundacion = new Fundacion();
		fundacion.setId((long) 1);

		// Si se necesita alguna Accion Requeride Entonces....
		when( // Insertando una fundacion
				fundacionRepositoryMock.save(any(Fundacion.class))).thenReturn(fundacion

		);
		
		/* Entonces Realizo la prueba si es verdadera*/
		Fundacion fundacionToAdd = new Fundacion((long) 0,"Mario", 48378965, "Calle LArga SUR",320489781,"abc@gmail.com");
		ResponseEntity<Object> responseEntity = fundacionController.addFundacion(fundacionToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}
	@Test
	public void testFindAll() {
		// given
		Fundacion fundacion1 = new Fundacion((long) 0,"Mario", 48378965, "Calle LArga SUR",320489781,"abc@gmail.com");
		Fundacion fundacion2 = new Fundacion((long) 0,"RAul", 483723465, "Calle NEW SUR",320489561,"www@gmail.com");
		List<Fundacion> list = new ArrayList<Fundacion>();
		list.addAll(Arrays.asList(fundacion1, fundacion2));

		when(fundacionRepositoryMock.findAll()).thenReturn(list);

		
		// when
		Fundacions result = fundacionController.getFundacions();

		// then
		assertThat(result.getFundacionList().size()).isEqualTo(2);

		assertThat(result.getFundacionList().get(0).getFun_name()).isEqualTo(fundacion1.getFun_name());

		assertThat(result.getFundacionList().get(1).getFun_name()).isEqualTo(fundacion2.getFun_name());
	}

	
	
	@Test
	public void updateFundacionTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Fundacion fundacion = new Fundacion();
		fundacion.setId((long) 1);

		when(fundacionRepositoryMock.save(any(Fundacion.class))).thenReturn(fundacion);

		// Entonces Realizo la prueba si es verdadera
		Fundacion fundacionToAdd = new Fundacion((long) 0,"Mario", 48378965, "Calle LArga SUR",320489781,"abc@gmail.com");
		ResponseEntity<Object> responseEntityCreate = fundacionController.addFundacion(fundacionToAdd);
		
		Fundacion fundacionToUpdate = new Fundacion((long) 0,"Mario", 48378965, "Calle LArga SUR",320489781,"abc@gmail.com");
		Fundacion responseEntityUpdate = fundacionController.updateFundacion(fundacionToUpdate);
		
		assertThat(responseEntityUpdate.equals(fundacionToUpdate));
		
	}
	
	@Test
	public void deleteFundacionTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Fundacion fundacionBase = new Fundacion();
		fundacionBase.setId((long) 1);
		
		when(fundacionRepositoryMock.save(any(Fundacion.class))).thenReturn(fundacionBase);

		// Entonces Realizo la prueba si es verdadera
		Fundacion fundacion = new Fundacion((long) 0,"Raul", 48378965, "Calle Baldor",320489781,"abc@gmail.com");
		ResponseEntity<Object> responseEntityCreate = fundacionController.addFundacion(fundacion);
		ResponseEntity<String> responseEntityUpdate = fundacionController.deleteFundacionApi(fundacion);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
	
}

