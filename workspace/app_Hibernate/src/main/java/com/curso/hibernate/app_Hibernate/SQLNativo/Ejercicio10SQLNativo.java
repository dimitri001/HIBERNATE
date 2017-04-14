package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio10SQLNativo {

	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Listar(){ 
	    
		// Manejo de asociaciones y colecciones
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		 @SuppressWarnings("unchecked")
		 
		
		       
		String patron = "Armando";
		List product = session.getNamedQuery("mySqlQuery")
				  .setString("name", patron)
				    .list();
		 
		 
		
		
		  for(int i=0; i< product.size(); i++) {     
		    	System.out.println("valor " + product.get(i).toString());  
		    }
		    
		
	    /* Iterator itr0 = product.iterator();
		 while(itr0.hasNext()){
		    Object[] obj = (Object[]) itr0.next();
		    //now you have one array of Object for each row
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    String idProducto = String.valueOf(obj[0]); // 
		    System.out.print("  idProducto: " +   idProducto.toString()+"'\n'"); 
		    String nombre = String.valueOf(obj[1]); // 
		    System.out.print("  nombre: " +   nombre.toString()+ "'\n'");
		   
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		 }*/
		 
		 
	
		 
		 
		  
	}
	
	public static void main(String[] args) { 	 
		 
		Ejercicio10SQLNativo   EjercicioSQLNativo10 = new Ejercicio10SQLNativo();
		 
		EjercicioSQLNativo10.Listar();
	}

}

