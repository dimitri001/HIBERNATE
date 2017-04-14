package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio11Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
		 
	     
		Producto product = new Producto();
		product.setNombre("Camisa Azul Oscura Caballero");
		Cliente cliente= new Cliente();
		product.setCliente(cliente);
			
		
		Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add( Example.create(product))
	      .list();  
	     
	      
	
		@SuppressWarnings("unchecked")
		List<Producto> productos = cr.list();
		    for (Producto producto : productos) {
		    	 System.out.println("---------------------------------------------EJERCICIO NUMERO 11 Criteria------------------------------------------------------" );
		    	 System.out.println("NOMBRE  Producto" + producto.getNombre());
		         System.out.println("CANTIDADES " + producto.getCantidades());
		         System.out.println("-------------------------------------------------------------------------------------------------------------------------------" );
		      		   
		     }
	  } 

     public static void main(String[] args) { 	 
	 
	 Ejercicio11Criteria   CriteriaEjercicio11 = new Ejercicio11Criteria();
	 
	 CriteriaEjercicio11.Listar();
	 
}


}
