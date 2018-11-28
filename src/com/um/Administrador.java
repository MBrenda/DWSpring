package com.um;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {

	private int idAd;
	private String nombre;
	
	//objeto de tipo direccion que voy a inyectar usando anotcion
	@Autowired
	private Direccion direccion;
	
	public void imprimirDireccion() {
		System.out.println("Balcarce 427");
	}
	
	public Administrador(int idAd, String nombre) {
		this.idAd = idAd;
		this.nombre = nombre;
	}

	public Administrador() {
		super();
	}
	
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	@Autowired - seria por seter
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	
}
