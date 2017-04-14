package com.curso.hibernate.app_Hibernate.SQLNativo;


import java.util.List;
import org.hibernate.Session;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;



public class Ejercicio4SQLNativo {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Ejercicio4SQLNativo(){ 
	    
		// Consultas de entidades.
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		 @SuppressWarnings("unchecked")
		 
		 List<Producto> productos=  session.createSQLQuery("SELECT * FROM PRODUCTO").addEntity(Producto.class).list();
	
		 System.out.println("---------------------------------------------Ejercicio4SQLNATIVE------------------------------------------------------" );
		 List<Producto> productos1 = productos;
		    for (Producto producto : productos1) {
		    	
		        System.out.println("NOMBRE " + producto.getNombre());
		        System.out.println("CANTIDADES " + producto.getCantidades());
		        System.out.println("---------------------------------------------------------------------------------------------------------------------" ); 
		     }
		  
		 
		 
		    System.out.println("---------------------------------------------Ejercicio4SQLNATIVEB------------------------------------------------------" );
		    @SuppressWarnings("unchecked")
			List<Producto> productosB= session.createSQLQuery("SELECT IDPRODUCTO, NOMBRE, CANTIDADES FROM PRODUCTO").addEntity(Producto.class).list();

		    List<Producto> productos2 = productosB;
		    for (Producto producto : productos2) {
		    	System.out.println("IDPRODUCTO " + producto.getIdProducto());
		        System.out.println("NOMBRE " + producto.getNombre());
		        System.out.println("CANTIDADES " + producto.getCantidades());
		        System.out.println("---------------------------------------------------------------------------------------------------------------------" ); 
		     }


		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio4SQLNativo   EjercicioSQLNativo4 = new Ejercicio4SQLNativo();
		 
		EjercicioSQLNativo4.Ejercicio4SQLNativo();
	}

}
