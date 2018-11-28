package com.um;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		Administrador administrador = (Administrador) applicationContext.getBean("admin");
	
		//va a mandar a llamar al metodo toString que va a ser lo que va a mostrar
		System.out.println(administrador);

		//		administrador.imprimirDireccion();
	
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
