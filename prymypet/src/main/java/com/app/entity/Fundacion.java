package com.app.entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Fundacion {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO , generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	private String fun_name;
	private int fun_nit;
	private String fun_dir;
	private int fun_cel;
	private String fun_email;
	
	
	public Fundacion(long id, String fun_name, int fun_nit, String fun_dir, int fun_cel, String fun_email) {
		super();
		this.id = id;
		this.fun_name = fun_name;
		this.fun_nit = fun_nit;
		this.fun_dir = fun_dir;
		this.fun_cel = fun_cel;
		this.fun_email = fun_email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fundacion fundacion = (Fundacion) o;
		return Objects.equals(id, fundacion.id) &&
			Objects.equals(fun_name, fundacion.fun_name) &&
			Objects.equals(fun_nit, fundacion.fun_nit) &&
			Objects.equals(fun_dir, fundacion.fun_dir) &&
			Objects.equals(fun_cel, fundacion.fun_cel) &&
			Objects.equals(fun_email, fundacion.fun_email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fun_name, fun_nit,fun_dir ,fun_cel , fun_email);
	}
	
	public Fundacion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFun_name() {
		return fun_name;
	}
	public void setFun_name(String fun_name) {
		this.fun_name = fun_name;
	}
	public int getFun_nit() {
		return fun_nit;
	}
	public void setFun_nit(int fun_nit) {
		this.fun_nit = fun_nit;
	}
	
	public String getFun_dir() {
		return fun_dir;
	}
	public void setFun_dir(String fun_dir) {
		this.fun_dir = fun_dir;
	}
	public int getFun_cel() {
		return fun_cel;
	}
	public void setFun_cel(int fun_cel) {
		this.fun_cel = fun_cel;
	}
	public String getFun_email() {
		return fun_email;
	}
	public void setFun_email(String fun_email) {
		this.fun_email = fun_email;
	}
		
	@Override
	public String toString() {
		return "Fundacion [id=" + id + ", fun_name=" + fun_name + ", fun_nit=" + fun_nit + ", fun_email=" + fun_email
				+ ", fun_dir=" + fun_dir + ", fun_cel=" + fun_cel + "]";
	}
}
