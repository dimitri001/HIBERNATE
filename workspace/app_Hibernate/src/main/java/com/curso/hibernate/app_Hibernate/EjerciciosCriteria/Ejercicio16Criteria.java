package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;
import java.lang.Double;


// Utilizar una DetachedCriteria para expresar una subconsulta. Las instancias de Criterion involucrando subconsultas
//  se pueden obtener por medio de Subqueries o Property. 


public class Ejercicio16Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
			    
	   
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    Transaction txn = session.beginTransaction();
        
		DetachedCriteria avgCantidades = DetachedCriteria.forClass(Producto.class)
		.setProjection( Property.forName("cantidades").avg() );
		session.createCriteria(Producto.class)
		.add(Property.forName("cantidades").gt(avgCantidades ) )
		.list();
			
		
		
		@SuppressWarnings("unchecked")
		//(List<Producto>)
		List <Producto> results = (List)  avgCantidades.getExecutableCriteria(session).list();
		
		
		
		System.out.println("---------------------------------------------EJERCICIO NUMERO 15 Criteria------------------------------------------------------"+ "\n");
		
		
	    System.out.println("NOMBRE PRODUCTO                       CANTIDADES                    NOMBRES                                 APELLIDOS" );
	    System.out.println("-----------------                     -----------                  ----------                               ----------");
	   
	 
	    
	    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
	    
		
	
		txn.commit();
		session.close();
	}
	
	
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio16Criteria   CriteriaEjercicio16 = new Ejercicio16Criteria();
		 
		 CriteriaEjercicio16.Listar();
	}

}
