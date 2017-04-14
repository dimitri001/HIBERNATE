package com.curso.hibernate.app_Hibernate.Anotaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Clientes;
import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Productos;
import com.curso.hibernate.app_Hibernate.Servicios.ProductoService;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;
import com.curso.hibernate.app_Hibernate.util.JPAUtil;

public class EjesrAnotaciones implements java.io.Serializable  {

	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public  void EjemploSAnotaciones()
	  {
		
	  
	    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductoService");  
	    EntityManager pro = emf.createEntityManager();     
	    try {
	    	JPAUtil util = new JPAUtil();
	    	
	    	pro.getTransaction().begin();
	    	Clientes clie = new Clientes(18,"","");
	    	ProductoService productoServicio = new ProductoService(pro);
	    		    	
	 	    
	    	Productos product = productoServicio.createProducto(clie,"Chaleco cuadro Escoces Rojos", 15);
	    	pro.getTransaction().commit();
	    	System.out.println("Persisted " + productoServicio);
	        util.checkData("select * from Producto");

	         pro.close();
		     emf.close();
	 	    
	    	
	    }catch (Exception e) {  
	    	pro.getTransaction().rollback();
	    	e.printStackTrace(); 
	    	}finally{
	    		   
	    		     }        
	    System.out.println("It is over");    
	    }
	
	    
	    
	   
	 
	    
	    
	    
	    
	  
	
}
