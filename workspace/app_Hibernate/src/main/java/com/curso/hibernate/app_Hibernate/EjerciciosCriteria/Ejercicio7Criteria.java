package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio7Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	  // Utilizando la Restrictions.like para filtrar  en dos campos 
	     
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add( Restrictions.like("nombre", "%azul%") )
	     .createCriteria("cliente")
	      .add( Restrictions.like("nombre", "Sel%") )
	     .list();
	     
	    
	     
	     List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio3Criteria------------------------------------------------------" );
		    System.out.println("NOMBRE PRODUCTO                       CANTIDADES                    NOMBRES                                 APELLIDOS" );
		    System.out.println("-----------------                     -----------                  ----------                               ----------");
		   
		    for (Producto producto : productos) {
		      
		    	 System.out.println( producto.getNombre()+"              "+producto.getCantidades()
			    	+"                "+producto.getCliente().getNombre()+"                     "+producto.getCliente().getApellidos()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
  
	     
	    
	  } 



public static void main(String[] args) { 	 
	 
	 Ejercicio7Criteria   CriteriaEjercicio7 = new Ejercicio7Criteria();
	 
	 CriteriaEjercicio7.Listar();
	 
}


}
