package com.um.dao;

import java.util.List;

import com.um.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin);
	
	//creo un metodo que me devuelve una lista de admins
	public List<Admin> findAll();
	
	//consultas personalizadsa
	public Admin findById(int id);
	public List<Admin> findByNombre(String nombre);
	public boolean update(Admin admin);
	public boolean delete(int idAd);
	public int[] saveAll(List<Admin> admins);
	
}
