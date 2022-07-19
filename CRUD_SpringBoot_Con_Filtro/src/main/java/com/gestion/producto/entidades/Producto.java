package com.gestion.producto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 60)//no puede ser un campo nulo y como maximo una longitud de 60 caracteres
	private String nombre;
	
	@Column(nullable = false, length = 60)//no puede ser un campo nulo y como maximo una longitud de 60 caracteres
	private String marca;
	
	@Column(nullable = false, length = 60)//no puede ser un campo nulo y como maximo una longitud de 60 caracteres
	private String hechoEn;
	
	@Column(nullable = false)//no puede ser un campo nulo
	private float precio;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(long id, String nombre, String marca, String hechoEn, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.hechoEn = hechoEn;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getHechoEn() {
		return hechoEn;
	}

	public void setHechoEn(String hechoEn) {
		this.hechoEn = hechoEn;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
