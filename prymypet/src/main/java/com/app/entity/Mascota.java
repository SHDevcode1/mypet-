package com.app.entity;
import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mascota {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	private String Nombre_Mascota;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_Mascota() {
		return Nombre_Mascota;
	}
	public void setNombre_Mascota(String nombre_Mascota) {
		Nombre_Mascota = nombre_Mascota;
	}
	@Override
	public String toString() {
		return "Mascota [id=" + id + ", Nombre_Mascota=" + Nombre_Mascota + "]";
	}
	public Mascota(Long id, String Nombre_Mascota) {
		super();
		this.id = id;
		this.Nombre_Mascota = Nombre_Mascota;
	}

	
	
}
