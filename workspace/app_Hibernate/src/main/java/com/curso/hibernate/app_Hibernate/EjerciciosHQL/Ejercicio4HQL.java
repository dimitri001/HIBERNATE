package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio4HQL {
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	  public void borrarCliente(Integer idCliente){ 

		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio4HQL******************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
		 Session session =  SesionHibernate().getSessionFactory().openSession(); 
	     Transaction tx = null; 
	     try{ 
	        tx = session.beginTransaction(); 
	        Cliente cliente =  
	                  (Cliente)session.get(Cliente.class, idCliente);  
	        session.delete(cliente);  
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
	  
	//Ejemplo que que borra el registro 18
	public static void main(String[] args) { 
		
		Ejercicio4HQL HQLEjercicio4 = new Ejercicio4HQL();
		 HQLEjercicio4.borrarCliente(18);
	}

}
