package com.curso.hibernate.app_Hibernate.Anotaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Clientes;
import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Productos;
import com.curso.hibernate.app_Hibernate.Servicios.ProductoService;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;
import com.curso.hibernate.app_Hibernate.util.JPAUtil;

public class EjerAnotaciones2 {
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public  void EjemploSAnotaciones2()
	  {
	
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductoService");  
	    EntityManager pro = emf.createEntityManager();     
	    
	  	    try {
	  	    	JPAUtil util = new JPAUtil();
	  	    	
	  	    	
	  	    	ProductoService productoServicio = new ProductoService(pro);
	  	    		    	
	  	 	    
	  	    	Productos product = productoServicio.findProducto(15);
	  	    	pro.getTransaction().commit();
	  	    	System.out.println("Persisted " + productoServicio);
	  	      

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
