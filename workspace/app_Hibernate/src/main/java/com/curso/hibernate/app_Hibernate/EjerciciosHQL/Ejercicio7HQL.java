package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio7HQL {
	

	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	 public  void HQLList( ){ 

		  Session session =  SesionHibernate().getSessionFactory().openSession(); 
		  Transaction tx = null; 
		  
		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************EJEMPLO METODO (HQL7List)******************************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
	
		  
		  
		  
	 try{     
		
    
		 tx = session.beginTransaction(); 
	     org.hibernate.Query query =  session.createQuery("from Cliente");
	    
	  
	      
	     
		   query =   session.createQuery("update Cliente set nombre = :nombre  where idCliente = :idCliente");
		   query.setString("nombre", "Juan Pablo");
	       query.setString("idCliente","17");//setParameter();
	       int result =  query.executeUpdate();
	       System.out.println("Rows affected: " + result);
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
		 
		 Ejercicio7HQL HQLEjercicio7 = new Ejercicio7HQL();
		 
		 HQLEjercicio7.HQLList();
		 
	}


}
