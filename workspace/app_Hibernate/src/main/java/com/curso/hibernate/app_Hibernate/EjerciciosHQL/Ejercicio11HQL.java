package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio11HQL {



	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	/* Ejemplo0 con Like saca los Clientes que su apellido empiece en B y termine en o
	   *  
	   */

	  public  void EjemploLike()
	  {
	     
		  Session session =  SesionHibernate().getSessionFactory().openSession();  
		  Transaction tx = null; 
		  tx = session.beginTransaction();

		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio11HQL (EjemploLike()************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
		  try{ 

			
			 org.hibernate.Query query = session.createQuery("SELECT e FROM Cliente e WHERE e.apellidos LIKE 'B%o'");
			  
			
			 
			 List clientes = ((org.hibernate.Query) query).list();
		     
		   
		     for (@SuppressWarnings("rawtypes")
			Iterator iterator =  

		         	clientes.iterator(); iterator.hasNext();){ 
		         	Cliente cliente = (Cliente) iterator.next();  

		            System.out.print("  Nombre Cliente: " +  cliente.getNombre()+ "  ");  
		            System.out.print("  Apellidos Cliente : " + cliente.getApellidos() + "  ");
		            System.out.print("   "     + "\n");
		            
		            
		           
		         } 
		     
			  
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
		 
		 Ejercicio11HQL HQLEjercicio11 = new Ejercicio11HQL();
		 
		 HQLEjercicio11.EjemploLike();
		 
	}

}


