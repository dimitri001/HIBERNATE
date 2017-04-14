package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio10HQL {
	
	

	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	/* HQL
	   * ejemplo JOIN entre los productos que pidieron los clientes, 
	   * 
	   */ 
	  
	  public  void EjemploUhnion2()
	  {
	     
		  Session session =  SesionHibernate().getSessionFactory().openSession();  
		  Transaction tx = null; 
		  tx = session.beginTransaction();

		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio10HQL(EjemploUnion)************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
		  try{ 

			
			  
			org.hibernate.Query query = session.createQuery("SELECT DISTINCT c FROM Cliente c JOIN c.productos p WHERE p.idProducto = 1 ORDER BY c.nombre");
			
		    
			 
			 @SuppressWarnings("rawtypes")
			List clientes = ((org.hibernate.Query) query).list();
		     
		   
		     for (@SuppressWarnings("rawtypes")
			Iterator iterator =  

		         	clientes.iterator(); iterator.hasNext();){ 
		         	Cliente cliente = (Cliente) iterator.next();  
		         	System.out.print("CLIENTE----------------------------------------------------------");
		            System.out.print("  Nombre Cliente: " +  cliente.getNombre()+ "  ");  
		            System.out.print("  Apellidos Cliente : " + cliente.getApellidos() + "  ");
		            System.out.print("   "     + "'\n'");
		            
		            
		            for (@SuppressWarnings("rawtypes")
					Iterator iterator2 =   cliente.getProductos().iterator(); iterator2.hasNext();)
		            {
		            	System.out.print("PRODUCTO----------------------------------------------------------");
		             	Producto producto =(Producto) iterator2.next();
		             	System.out.print("  Nombre Producto : " + producto.getNombre() + "  ");
			            System.out.print("  "     + "'\n'");
		            }
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
		 
		 Ejercicio10HQL HQLEjercicio10 = new Ejercicio10HQL();
		 
		 HQLEjercicio10.EjemploUhnion2();
		 
	}


}
