package com.curso.hibernate.app_Hibernate.configuracionSesion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Configuracion {

	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry; 
    
    
	public void configuracionSession ()
	{
	
	
		
		try{ 

	        Configuration configuration = new Configuration().configure();

	        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	        
	     }catch (Throwable ex) {  

	        System.err.println("Error al crear el objeto sessionFactory." + ex); 
	        throw new ExceptionInInitializerError(ex);  
	     } 
	}
	
	public SessionFactory getSessionFactory()
	
	  {
		configuracionSession ();
		return sessionFactory;
	  } 
	
}
