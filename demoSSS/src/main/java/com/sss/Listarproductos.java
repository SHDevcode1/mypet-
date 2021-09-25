package com.sss;
import java.io.Serializable;
public class Listarproductos {
private static final long serialVersionUID =1l;
private long id;
private String nombre;
private String descripcion;
private String tienda;
private double precio;
public long getId() {
	return id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getdescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getTienda() {
	return tienda;
}
public void setTienda(String tienda) {
	this.tienda = tienda;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(long precio) {
	this.precio = precio;
}
public void setId(long id) {
	this.id = id;
}

public static long getSerialversion() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Listarproductos [id=" + id + ", nombre=" + nombre + ", tienda=" + tienda + ", precio=" + precio + "]";
}
public Listarproductos(long id, String nombre, String tienda,long precio) {
	this.id=id;
	this.nombre=nombre;
	this.tienda=tienda;
	this.precio=precio;
}
public Listarproductos() {
	super();
}
}
