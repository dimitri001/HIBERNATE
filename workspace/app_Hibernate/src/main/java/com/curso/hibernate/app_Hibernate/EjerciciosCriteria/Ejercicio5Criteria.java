package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio5Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void ListarProperty2(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     // Utilizando la Restrictions.eq   
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add(Restrictions.eq("nombre","Camisa Rosa Caballero"));
	    
	     
	     List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio5Criteria------------------------------------------------------" );
		    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
		    System.out.println("---------       ----------         ------                               ----------");
		    for (Producto producto : productos) {
		      
		    	 System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
			    	+"                "+producto.getNombre()+"                  "+producto.getCantidades()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
  
  
	  } 
	
	
	
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio5Criteria   CriteriaEjercicio5 = new Ejercicio5Criteria();
		 
		 CriteriaEjercicio5.ListarProperty2();
	}
	


}
