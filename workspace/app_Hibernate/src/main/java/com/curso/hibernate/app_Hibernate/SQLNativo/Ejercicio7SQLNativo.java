package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio7SQLNativo {

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
		 
		
			Query query = session.createSQLQuery(
			"select * from producto p where p.idProducto = :idProducto")
			.setParameter("idProducto", "21");
		 @SuppressWarnings("unchecked")
		 List<Object> productos= (List<Object>)query.list();
       
		
		
		 System.out.println("---------------------------------------------Ejercicio7SQLNATIVE------------------------------------------------------" );
		 Iterator itr0 = productos.iterator();
		 while(itr0.hasNext()){
		    Object[] obj = (Object[]) itr0.next();
		    //now you have one array of Object for each row
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    String idProducto = String.valueOf(obj[0]); // 
		    System.out.print("  idProducto: " +   idProducto.toString()+"'\n'"); 
		    String nombre = String.valueOf(obj[1]); // 
		    System.out.print("  nombre: " +   nombre.toString()+ "'\n'");
		    String cantidades = String.valueOf(obj[2]); // 
		    System.out.print("  Cantidades: " +   cantidades.toString()+ "'\n'");
		    String idCliente = String.valueOf(obj[3]); 
		    System.out.print("  idCliente: " +   idCliente.toString()+ "'\n'");
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		 }
		  
		 
		 
				

		
		 
		
		 
		 
		
		 
		
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio7SQLNativo   EjercicioSQLNativo7 = new Ejercicio7SQLNativo();
		 
		EjercicioSQLNativo7.Listar();
	}

}



