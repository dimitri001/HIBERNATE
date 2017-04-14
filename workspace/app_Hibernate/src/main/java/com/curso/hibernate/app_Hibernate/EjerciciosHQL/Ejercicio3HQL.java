package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio3HQL {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	public void actualizarCliente(Integer idCliente, String Apellidos ){ 

		 Session session =  SesionHibernate().getSessionFactory().openSession(); 
	     Transaction tx = null; 
	    
	     System.out.println("                                                                                                                                            ");
		 System.out.println("                                                                                                                                            ");
	     System.out.println("********************************************************************************************************************************************");
	  	 System.out.println("*************************************************Ejercicio3HQL******************************************************************");
	  	 System.out.println("********************************************************************************************************************************************"); 
	     
	     try{ 
	        tx = session.beginTransaction(); 
	        Cliente  cliente =  
	                   (Cliente)session.get(Cliente.class, idCliente);  
	        cliente.setApellidos(Apellidos);
	        session.update(cliente);  
	        tx.commit(); 

	     }catch (HibernateException e) { 

	    	 if (tx!=null) tx.rollback(); 
	        e.printStackTrace();  
	     }finally { 
	        session.close();  
	     } 
	     
	     System.out.println("********************************************************************************************************************************************");
		 System.out.println("********************************************************************************************************************************************");
		 System.out.println("                                                                                                                                            ");
		 System.out.println("                                                                                                                                            ");
	  } 
	
		// Ejemplo que realiza una actualización
		
		public static void main(String[] args) { 
			
			 Ejercicio3HQL HQLEjercicio3 = new Ejercicio3HQL();
			 HQLEjercicio3.actualizarCliente(5, "Carmona");
		}
	}


