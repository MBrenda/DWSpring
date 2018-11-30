package com.um;

import java.sql.Timestamp;
import java.util.ArrayList;
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
		
//		Admin admin = new Admin();
//		admin.setCargo("gerente");
//		admin.setNombre("Martin");
//		admin.setFechaCreacion(ts);
//		
		try{
			//invocar metodo del dao para salvar
//			adminDao.save(admin);
//		
			 
			
//			List<Admin> admins = adminDao.findAll();
//		
//			for (Admin admin2 : admins) {
//				System.out.println(admin2);
//			}
			
			/*System.out.println(adminDao.findById(1));
			System.out.println(adminDao.findById(4));
			System.out.println(adminDao.findByNombre("j").toString());*/
//			Admin admin = adminDao.findById(1);
			
		//	 System.out.println("Admin con id 1:" + admin);
		//	 
		//	 admin.setCargo("subgerente");
		//	 admin.setNombre("martin rojo");
		//	 
		//	 if(adminDao.update(admin)) {
		//		 //si retorna true es porque se actualizo
		//		 System.out.println("Actualizado correctamente" + admin);
		//		 
		//	 }
		//	 
		//	 if(adminDao.delete(admin.getIdAd())) {
		//		 System.out.println("Admin: " + admin.getNombre() + "eliminado correctamente");
		//	 }

			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin(30, "pedro", "jefe de ingenieria", ts));
			admins.add(new Admin(31, "jorge", "subjefe de ingenieria", ts));
			admins.add(new Admin(32, "maria", "representante de ingenieria", ts));
			
			
			int [] valores = adminDao.saveAll(admins);
			
			for( int i : valores) {
				System.out.println("Filas afectadas por esta operacion " + i);
			}
			
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
