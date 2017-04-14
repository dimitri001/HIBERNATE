package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio9HQL {
	

	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	  /* HQL
	   * ejemplo, 
	   * 
	   */ 
	  public  void EjemploUhnion1()
	  {
	     
		  Session session =  SesionHibernate().getSessionFactory().openSession();  
		  Transaction tx = null; 
		  tx = session.beginTransaction();

		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio9HQL (EjemploUhnion)************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
		  try{ 

		
			//Ejemplo0 con JOIN FETCH y JOIN  entre las tabla Clientes y productos
			org.hibernate.Query query = session.createQuery(" SELECT DISTINCT c FROM Cliente c JOIN FETCH c.productos p JOIN p.cliente");
				
			
			 List clientes = ((org.hibernate.Query) query).list();
		     
		    
		     for (@SuppressWarnings("rawtypes")
			Iterator iterator =  

		         	clientes.iterator(); iterator.hasNext();){ 
		         	Cliente cliente = (Cliente) iterator.next();  
		         	System.out.print("CLIENTE----------------------------------------------------------");
		            System.out.print("  Nombre Cliente: " +  cliente.getNombre()+ "  ");  
		            System.out.print("  Apellidos Cliente : " + cliente.getApellidos() + "  ");
		            System.out.print("   "     + "'\n'");
		            
		            
		            for (Iterator iterator2 =   cliente.getProductos().iterator(); iterator2.hasNext();)
		            {
		             	Producto producto =(Producto) iterator2.next();
		             	System.out.print("PRODUCTO----------------------------------------------------------");
		             	System.out.print("  Nombre Producto comprado: " + producto.getNombre() + "  ");
			            System.out.print("  "     + "'\n'");
		            }
		            
		            System.out.println("                                                                                                                    ");
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
		 
		 Ejercicio9HQL HQLEjercicio9 = new Ejercicio9HQL();
		 
		 HQLEjercicio9.EjemploUhnion1();
		 
	}

}
