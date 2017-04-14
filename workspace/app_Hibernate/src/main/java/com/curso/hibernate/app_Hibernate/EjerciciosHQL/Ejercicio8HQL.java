package com.curso.hibernate.app_Hibernate.EjerciciosHQL;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio8HQL {
	

	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	//Ejemplo que que crea un mapa de los datos recogidos
	
	public   void obtenNombresYapellidos()
	  {
	     
		  Session session =  SesionHibernate().getSessionFactory().openSession(); 
		  Transaction tx = null; 
		  tx = session.beginTransaction();

		  System.out.println("                                                                                                                                            ");
		  System.out.println("                                                                                                                                            ");
		  System.out.println("********************************************************************************************************************************************");
		  System.out.println("*************************************************Ejercicio8HQ****************************************************");
		  System.out.println("********************************************************************************************************************************************");
		  
		  try{ 

			  org.hibernate.Query query = session.createQuery("SELECT new map(u.idCliente as identificador, u.nombre as nombre, u.apellidos as apellidos) FROM Cliente as u ");

			  List<Map> listaResultados = query.list();

			  for (int i = 0; i < listaResultados.size(); i++)
			  		{
				  		Map mapa = listaResultados.get(i);

				  		System.out.println("Datos del Registro " + i);

				  		java.util.Set llaves =  mapa.keySet();

				  		for(Iterator<String> it = ((Iterable) llaves).iterator(); it.hasNext();)
				  			{
				  				String llaveActual = it.next();

				  				System.out.println("\tLlave: " + llaveActual + " valor: " + mapa.get(llaveActual));
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
		 
		 Ejercicio8HQL HQLEjercicio8 = new Ejercicio8HQL();
		 
		 HQLEjercicio8.obtenNombresYapellidos();
		 
	}

}
