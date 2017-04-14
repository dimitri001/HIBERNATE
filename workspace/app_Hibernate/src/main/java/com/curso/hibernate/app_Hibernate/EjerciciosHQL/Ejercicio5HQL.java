package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio5HQL {
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
	}
	
	// Ejempo que que lista el cliente con el código 1
	public  void HQL5List( ){ 

		  Session session =  SesionHibernate().getSessionFactory().openSession(); 
		  Transaction tx = null; 
		  
		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio5HQL******************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		       
	    
		  
	 try{ 
	     org.hibernate.Query query = session.createQuery("from Cliente where idCliente = :code ");
	     query.setParameter("code", 1);
	     List clientes = query.list();
	    
	     for (Iterator iterator =  

	         	clientes.iterator(); iterator.hasNext();){ 
	         	Cliente cliente = (Cliente) iterator.next();  

	            System.out.print("  Nombre: " +  cliente.getNombre()+ "  ");  
	            System.out.print("  Apellidos : " + cliente.getApellidos() + "'\n'");  
	              
	         } 
	     
	     org.hibernate.Query query2 = session.createQuery("from Cliente where idCliente = '1' ");
	     clientes= query.list();

	     for (Iterator iterator =  

	          	clientes.iterator(); iterator.hasNext();){ 
	          	Cliente cliente = (Cliente) iterator.next();  

	             System.out.print("  Nombre: " +  cliente.getNombre()+ "  ");  
	             System.out.print("  Apellidos : " + cliente.getApellidos() + "'\n'");  
	               
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
		
		Ejercicio5HQL HQLEjercicio5 = new Ejercicio5HQL();
		 HQLEjercicio5.HQL5List();
	}

}
