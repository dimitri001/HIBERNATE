package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.List;

import org.hibernate.Session;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio5SQLNativo {
	
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
		 
		// List<Producto> productos=  session.createSQLQuery("SELECT * FROM PRODUCTO").addEntity(Producto.class).list();
		
		 
		 List<Producto> productos= session.createSQLQuery("SELECT {producto.*}, {cliente.*} FROM PRODUCTO producto, CLIENTE cliente WHERE producto.idCliente = cliente.idCliente")
		.addEntity("producto", Producto.class)
		.addJoin("cliente.idCliente", "producto.idCliente").list();

		 
		 
		 
		 
		// List<Producto> productos1 = productos;
		 //   for (Producto producto : productos1) {
		 //   	System.out.println("---------------------------------------------Ejercicio4SQLNATIVE------------------------------------------------------" );
		  //      System.out.println("NOMBRE " + producto.getNombre());
		  //      System.out.println("CANTIDADES " + producto.getCantidades());
		  //      System.out.println("---------------------------------------------------------------------------------------------------------------------" ); 
		  //   }
		  
		 
		 
		 
		//    @SuppressWarnings("unchecked")
		//	List<Producto> productosB= session.createSQLQuery("SELECT IDPRODUCTO, NOMBRE, CANTIDADES FROM PRODUCTO").addEntity(Producto.class).list();

		 //   List<Producto> productos2 = productosB;
		 //   for (Producto producto : productos2) {
		 //   	System.out.println("---------------------------------------------Ejercicio4SQLNATIVEB------------------------------------------------------" );
		 //       System.out.println("IDPRODUCTO " + producto.getIdProducto());
		 //       System.out.println("NOMBRE " + producto.getNombre());
		 //       System.out.println("CANTIDADES " + producto.getCantidades());
		 //       System.out.println("---------------------------------------------------------------------------------------------------------------------" ); 
		  //   }


		 
		
		 
		 
		
		 
		
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio5SQLNativo   EjercicioSQLNativo5 = new Ejercicio5SQLNativo();
		 
		EjercicioSQLNativo5.Listar();
	}

}
