package com.um.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.um.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	
	//voy a crear una propiedad que es una plantilla que me va ayudar con las operaciones en la bd
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//spring va a instanciar y crear este bean y configurarlo por mi
	//al inyectarlo aca ya puedo usarlo en los metodos que defina acá
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
		MapSqlParameterSource paramMap = new MapSqlParameterSource(); 
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		//me devuelve el numero de filas afectadas == 1
		return jdbcTemplate.update("insert into Admin(nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
				
	}

}
