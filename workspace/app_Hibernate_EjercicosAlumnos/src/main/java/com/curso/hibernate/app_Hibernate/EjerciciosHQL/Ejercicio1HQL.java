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
		
		
		 
		 
		 public void  ejercicio1HQL(){ 
			 
		     Session session =  SesionHibernate().getSessionFactory().openSession(); 
		    
		   
		    
		    
		  } 
		 
		 
	 public static void main(String[] args) { 	 
		 
		 Ejercicio1HQL HQLEjercicio1 = new Ejercicio1HQL();
		 
		 HQLEjercicio1.ejercicio1HQL();
		 
	}
}
