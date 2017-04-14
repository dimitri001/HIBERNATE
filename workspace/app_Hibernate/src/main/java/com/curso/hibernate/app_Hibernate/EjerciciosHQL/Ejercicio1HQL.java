package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;



public class Ejercicio1HQL {
	
	
	
	
		
		
		
		public Configuracion SesionHibernate()
		{
			
			Configuracion sesionEntrono = new Configuracion();
			return sesionEntrono;
			
			
		}
		
		
		 // Ejemplo que añade un nuevo registro en la tabla cliente
		 
		 public Integer addCliente(String nombre, String apellidos){ 
			 
		     Session session =  SesionHibernate().getSessionFactory().openSession(); 
		    
		     Transaction tx = null; 
		     Integer clienteID = null; 
		     
		     
		     try{   

		        tx = session.beginTransaction(); 
		        Cliente cliente = new Cliente(nombre,apellidos); 
		        clienteID = (Integer) session.save(cliente);  
		        tx.commit(); 

		     }catch (HibernateException e) { 

		        if (tx!=null) tx.rollback(); 
		        e.printStackTrace();  

		     }finally { 

		    	 session.close();  
		     } 

		     return clienteID; 
		    
		  } 
		 
		 
	 public static void main(String[] args) { 	 
		 
		 Ejercicio1HQL HQLEjercicio1 = new Ejercicio1HQL();
		 
		 HQLEjercicio1.addCliente("Pacorro", "Tacones Garcia");
		 
	}
}
