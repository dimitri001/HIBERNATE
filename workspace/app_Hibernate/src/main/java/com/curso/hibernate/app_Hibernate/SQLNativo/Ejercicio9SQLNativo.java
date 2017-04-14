package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio9SQLNativo {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Ejercicio9SQLNativo1(){ 
	    
		// Manejo de asociaciones y colecciones
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		 @SuppressWarnings("unchecked")
		 
		
		       
		 String patron = "Camisa Roja%";
		 List product = session.getNamedQuery("ClientesNombrados1")
		 .setString("nameProductos", patron).list();
		 
		 
		
		 
		 Iterator itr0 = product.iterator();
		 while(itr0.hasNext()){
		    Object[] obj = (Object[]) itr0.next();
		    //now you have one array of Object for each row
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    String idProducto = String.valueOf(obj[0]); // 
		    System.out.print("  idProducto: " +   idProducto.toString()+"'\n'"); 
		    String nombre = String.valueOf(obj[1]); // 
		    System.out.print("  nombre: " +   nombre.toString()+ "'\n'");
		   
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		 }
		  
	
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio9SQLNativo   EjercicioSQLNativo9 = new Ejercicio9SQLNativo();
		 
		EjercicioSQLNativo9.Ejercicio9SQLNativo1();
	}





}
