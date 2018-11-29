package com.um.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.um.pojo.Admin;
import com.um.pojo.AdminRowMapper;

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
	/*	MapSqlParameterSource paramMap = new MapSqlParameterSource(); 
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());*/
		
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin); 
		
		//me devuelve el numero de filas afectadas == 1
		return jdbcTemplate.update("insert into Admin(nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
				
	}

	@Override
	public List<Admin> findAll() {
		// Todas las filas que me devuelva esta consulta mediante jdbctemplate, las estoy mapeando a mi java bean administrador para obtener una lista de administradores
		return jdbcTemplate.query("select * from Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Admin admin = new Admin();
				
				admin.setIdAd(rs.getInt("idAd"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				admin.setNombre(rs.getString("nombre"));
				
				return admin;
			}
			
		});
	}

	
	//gracias al adminRowMapper me va a devolver una instancia de Admin con esa consulta sql
	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		//me va a devolver un object
		return jdbcTemplate.queryForObject("select * from Admin where idAd= :idAd", new MapSqlParameterSource("idAd", id), new AdminRowMapper());
		
	}
	
	@Override
	public List<Admin> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from Admin where nombre like :nombre", 
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

}
