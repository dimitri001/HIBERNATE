package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio2HQL {
	
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	
	//Ejemplo que lista la tabla clientes
	 public void listClientes( ){ 

		  Session session =  SesionHibernate().getSessionFactory().openSession(); 
	     Transaction tx = null; 

	     try{ 
	    	 
	      System.out.println("                                                                                                                                            ");
	   	  System.out.println("                                                                                                                                            ");
	      System.out.println("********************************************************************************************************************************************");
	   	  System.out.println("*************************************************Ejercicio2HQL******************************************************************");
	   	  System.out.println("********************************************************************************************************************************************");
	      
	   	  tx = session.beginTransaction(); 
	      List clientes = session.createQuery("FROM Cliente").list();  

	        for (Iterator iterator =  

	        	clientes.iterator(); iterator.hasNext();){ 
	        	Cliente cliente = (Cliente) iterator.next();  

	           System.out.print("  Nombre: " +  cliente.getNombre()+ "  ");  
	           System.out.print("  Apellidos : " + cliente.getApellidos() + "'\n'");  
	             
	        } 
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
	  
	
	
	
	
	
	
	
	
	public static void main(String[] args) { 
		
		 Ejercicio2HQL HQLEjercicio2 = new Ejercicio2HQL();
		 HQLEjercicio2.listClientes();
	}

}
