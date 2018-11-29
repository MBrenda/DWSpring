package com.um;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.um.dao.AdminDao;
import com.um.pojo.Admin;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		//creo una instancia de admin dao
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		Admin admin = new Admin();
		admin.setCargo("gerente");
		admin.setNombre("Juancito");
		admin.setFechaCreacion(ts);
		
		//invocar metodo del dao
		if(adminDao.save(admin)) {
			System.err.println("Admin salvado correctamente");
		}
		else {
			System.err.println("Error al insertar administrador");
		}
		
		
	
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
