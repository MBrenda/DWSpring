package com.um;

public class Administrador {

	private int idAd;
	private String nombre;
	
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

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + "]";
	}

}
