package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;


import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio12Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	// Proyecciones, agregación y agrupamiento

	
	public void Listar(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	        
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.setProjection(Projections.rowCount());
	     cr.add( Restrictions.like("nombre","Camisa%"))
	     .list();
	     
	     System.out.println("---------------------------------------------EJERCICIO NUMERO 12 Criteria------------------------------------------------------" );    
	    
	     System.out.println("Número total que cumple el criterio" + cr.list().toString() );
		
	     System.out.println("-------------------------------------------------------------------------------------------------------------------------------" );
		  } 



public static void main(String[] args) { 	 
	 
	Ejercicio12Criteria   CriteriaEjercicio12 = new Ejercicio12Criteria();
	 
	 CriteriaEjercicio12.Listar();
	 
}


}
