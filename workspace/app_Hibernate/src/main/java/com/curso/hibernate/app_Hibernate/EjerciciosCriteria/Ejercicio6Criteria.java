package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio6Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void Listar(){ 
		 
		int minCantidad = 6;
		int maxCantidad = 25;
		Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    Criteria cr = session.createCriteria(Producto.class);
	   
	
	    // Utilizando la Restrictions.like que encuentre en los registros que comiencen por Camisa pasando los parametros
	    // minCantidad = 6 y maxCantidad = 25; para que los resultado se encuentren entre dichas cantidades.
	    
	 	cr.add( Restrictions.like("nombre", "Camisa%") )
		.add(Restrictions.between("cantidades", minCantidad, maxCantidad));
		    
	 	
	 	
	 	
	    
	     List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio6Criteria------------------------------------------------------" );
		    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
		    System.out.println("---------       ----------         ------                               ----------");
		    for (Producto producto : productos) {
		      
		    	 System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
			    	+"                "+producto.getNombre()+"                  "+producto.getCantidades()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
 
	  
	  } 



public static void main(String[] args) { 	 
	 
	 Ejercicio6Criteria   CriteriaEjercicio6 = new Ejercicio6Criteria();
	 
	 CriteriaEjercicio6.Listar();
	 
}

}
