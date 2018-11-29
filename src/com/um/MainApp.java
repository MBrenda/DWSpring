package com.um;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

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
		admin.setNombre("Pepecito");
		admin.setFechaCreacion(ts);
		
		try{
			//invocar metodo del dao
			adminDao.save(admin);
			
//			List<Admin> admins = adminDao.findAll();
//		
//			for (Admin admin2 : admins) {
//				System.out.println(admin2);
//			}
			
			System.out.println(adminDao.findById(1));
			System.out.println(adminDao.findById(4));
			System.out.println(adminDao.findByNombre("j").toString());
			
		} 
		catch (CannotGetJdbcConnectionException ex) {
				ex.printStackTrace();	
		} 
		catch (DataAccessException ex) { //error en el acceso a los datos
				ex.printStackTrace();
		}
	
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
