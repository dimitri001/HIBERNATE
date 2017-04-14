package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.List;

import org.hibernate.Session;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio6SQLNativo {
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Ejercicio6SQLNativo(){ 
	    
		// Manejo de asociaciones y colecciones
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		 @SuppressWarnings("unchecked")
		 
		
		
		 
		 List<Producto> productos= session.createSQLQuery(
					"select * from producto p where p.idProducto = :idProducto")
					.addEntity(Producto.class)
					.setParameter("idProducto", "21").list();

		 
		
		    for (Producto producto : productos) {
		    	System.out.println("---------------------------------------------Ejercicio6SQLNATIVE------------------------------------------------------" );
		       System.out.println("NOMBRE " + producto.getNombre());
		       System.out.println("CANTIDADES " + producto.getCantidades());
		       System.out.println("---------------------------------------------------------------------------------------------------------------------" ); 
		   }
		  
		 
		
		
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio6SQLNativo   EjercicioSQLNativo6 = new Ejercicio6SQLNativo();
		 
		EjercicioSQLNativo6.Ejercicio6SQLNativo();
	}

}



