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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.controller.ProductsController;
import com.app.entity.Products;
import com.app.entity.Productss;
import com.app.repository.ProductsCRUDRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DemoSahApplicationTests {
	
	@InjectMocks
	ProductsController productsController;

	@Mock
	ProductsCRUDRepository productsRepositoryMock;

	
	//Prueba Agregar productos
		@Test
		public void testAddProducts() {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
			
			Products products = new Products((long) 0, "Concentrado", 2);
			products.setId((long)1);
			
			when(productsRepositoryMock.save(any(Products.class))).thenReturn(products);
			
			//Prueba si es verdadera
			Products productsToAdd = new Products((long) 1, "Concentrado", 2);
			Products responseEntity = productsController.addProductsApi(productsToAdd);
			assertThat(responseEntity.getProduct_description()).isEqualTo("Concentrado");
		}
		
		
	//Prueba Obtener Productos
	@Test
	public void testfindAll() {
		// given
		Products product1 = new Products((long) 0, "Concentrado", 0);
		Products product2 = new Products((long) 0, "Concentrado2",0);
		
		List<Products> list = new ArrayList<Products>();
		list.addAll(Arrays.asList(product1, product2));
		
		when(productsRepositoryMock.findAll()).thenReturn(list);
		
		Productss result = productsController.getProductsList();
		
		//Entonces
		assertThat(result.getProductsList().size()).isEqualTo(2);
		
		assertThat(result.getProductsList().get(0).getProduct_description()).isEqualTo(product1.getProduct_description());
		
		assertThat(result.getProductsList().get(1).getProduct_description()).isEqualTo(product2.getProduct_description());
	}
	
	//Prueba Actualizar
	public void updateProductTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Products products = new Products((long) 0, "Concentrado", 2);
		products.setId((long)1);
		
		when(productsRepositoryMock.save(any(Products.class))).thenReturn(products);
		
		//Si es verdadera
		Products productsToAdd = new Products((long) 1, "Concentrado", 2);
		Products responseEntity = productsController.addProductsApi(productsToAdd);
		
		Products productsToUpdate = new Products((long) 1, "Concentrado2", 2);
		Products responseEntityUpdate = productsController.updateProducts(productsToUpdate);
		
		assertThat(responseEntityUpdate.equals("Concentrado2"));

	}
	
	
}
