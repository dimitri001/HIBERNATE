package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio2SQLNativo {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Listar(){ 
	    
		// Consultas escalares con  addScalar.
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		 @SuppressWarnings("unchecked")
		List<Object> productos= (List<Object>)
		 session.createSQLQuery("SELECT * FROM PRODUCTO").addScalar("idProducto",  new LongType())
		                                                 .addScalar("nombre", new StringType()).list();
		                                              

		
		 System.out.print(" ************************Ejercicio2SQLNativo************************************ "+ "'\n'"); 
		 Iterator itr0 = productos.iterator();
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
		 
		Ejercicio2SQLNativo   EjercicioSQLNativo2 = new Ejercicio2SQLNativo();
		 
		EjercicioSQLNativo2.Listar();
	}


}
