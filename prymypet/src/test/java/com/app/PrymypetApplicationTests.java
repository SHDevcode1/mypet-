package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

import com.app.controller.ShopController;
import com.app.entity.ListShops;
import com.app.entity.Shop;
import com.app.repository.ShopCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class PrymypetApplicationTests {
	
	@InjectMocks
	ShopController shopController;

	@Mock
	ShopCRUDRepository shopRepositoryMock;

	/*@Test
	public void testAddEmployee() {

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Employee employee = new Employee();
		employee.setId((long) 1);

		// When alguna Accion Requerida Entonces....
		when( // Insertando un empleado
				employeeRepositoryMock.save(any(Employee.class))).thenReturn(employee

		);

		// Entonces Realizo la prueba si es verdadera
		Employee employeeToAdd = new Employee((long) 0, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		ResponseEntity<Object> responseEntity = employeeController.addEmployee(employeeToAdd);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

	}
*/
	@Test
	public void testFindAll() {
		// given
		Shop Shop1 = new Shop((long) 002, "Bello", "Animalae", "CRA42");
		Shop Shop2 = new Shop((long) 0, "Bello", "Animo", "Cra 44");
		List<Shop> list = new ArrayList<Shop>();
		list.addAll(Arrays.asList(Shop1, Shop2));

		when(shopRepositoryMock.findAll()).thenReturn(list);

		
		// when
		ListShops result = shopController.getAllShopApi();

		// then
		assertThat(result.getShopList().size()).isEqualTo(2);

		assertThat(result.getShopList().get(0).getShop_name()).isEqualTo(Shop1.getShop_name());

		assertThat(result.getShopList().get(1).getShop_name()).isEqualTo(Shop2.getShop_name());
	}

	/*
	
	@Test
	public void updateEmployeeTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Employee employee = new Employee();
		employee.setId((long) 1);

		when(employeeRepositoryMock.save(any(Employee.class))).thenReturn(employee);

		// Entonces Realizo la prueba si es verdadera
		Employee employeeToAdd = new Employee((long) 0, "Dua", "Lipa", "superman@gmail.com");
		ResponseEntity<Object> responseEntityCreate = employeeController.addEmployee(employeeToAdd);
		
		Employee employeeToUpdate = new Employee((long) 0, "Super", "Man", "howtodoinjava@gmail.com");
		Employee responseEntityUpdate = employeeController.updateEmployee(employeeToUpdate);
		
		assertThat(responseEntityUpdate.equals(employeeToUpdate));
		
	}

	
	@Test
	public void deleteEmployeeTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Employee employeeBase = new Employee();
		employeeBase.setId((long) 1);
		
		when(employeeRepositoryMock.save(any(Employee.class))).thenReturn(employeeBase);

		// Entonces Realizo la prueba si es verdadera
		Employee employee = new Employee((long) 0, "Dua", "Lipa", "dualipa@gmail.com");
		ResponseEntity<Object> responseEntityCreate = employeeController.addEmployee(employee);
		
		ResponseEntity<String> responseEntityUpdate = employeeController.deleteEmployeeApi(employee);
				
		assertThat(responseEntityUpdate.equals(  HttpStatus.OK ));
		
	}
	*/
	
	
}

