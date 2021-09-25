package com.DVA;

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

import com.DVA.controller.MascotaController;
import com.DVA.entity.Mascota;
import com.DVA.entity.Mascotas;
import com.DVA.repository.MascotaCRUDRepository;

@ExtendWith(MockitoExtension.class)

public class TestUnitario {
	
	@InjectMocks
	MascotaController mascotaController;

	@Mock
	MascotaCRUDRepository mascotaRepositoryMock;

	@Test
	public void testFindAll() {
		// given
		Mascota Mascota1 = new Mascota((long) 0, "Loki");
		Mascota Mascota2 = new Mascota((long) 0, "Alex");
		List<Mascota> list = new ArrayList<Mascota>();
		list.addAll(Arrays.asList(Mascota1, Mascota2));

		when(mascotaRepositoryMock.findAll()).thenReturn(list);

		
		// when
		Mascotas result = mascotaController.getMascotas();

		// then
		assertThat(result.getMascotasList().size()).isEqualTo(2);

		assertThat(result.getMascotasList().get(0).getNombre_Mascota()).isEqualTo(Mascota1.getNombre_Mascota());

		assertThat(result.getMascotasList().get(1).getNombre_Mascota()).isEqualTo(Mascota2.getNombre_Mascota());
	}

}
