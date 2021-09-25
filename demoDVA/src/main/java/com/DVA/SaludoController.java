package com.DVA;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
	@RestController
	@CrossOrigin
public class SaludoController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/saludo")
	public Saludo saludo(@RequestParam(value="name", defaultValue="World") String name) {
		return new Saludo (counter.incrementAndGet(), String.format(template,name));
	}
}
