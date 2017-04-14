package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;



/*Consultas y subconsultas separadas
 * 
 * La clase DetachedCriteria le permite crear una consulta fuera del ámbito
 * de una sesión y luego ejecutarla usando una Session arbitraria. 
 *
 */

public class Ejercicio15Criteria {
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
	
	DetachedCriteria query = DetachedCriteria.forClass(Producto.class)
	.add( Property.forName("cantidades").eq(5) );
		    
	    Session session =  SesionHibernate().getSessionFactory().openSession(); 
		
	    Transaction txn = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Producto> productos =  query.getExecutableCriteria(session).setMaxResults(100).list();

	
			System.out.println("---------------------------------------------EJERCICIO NUMERO 15 Criteria------------------------------------------------------"+ "\n");
			
			
		    System.out.println("NOMBRE PRODUCTO                       CANTIDADES                    NOMBRES                                 APELLIDOS" );
		    System.out.println("-----------------                     -----------                  ----------                               ----------");
		   
		    for (Producto producto : productos) {
		      
		    	 System.out.println( producto.getNombre()+"              "+producto.getCantidades()
			    	+"                "+producto.getCliente().getNombre()+"                     "+producto.getCliente().getApellidos()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
		    
		    
		    
		    txn.commit();
		session.close();
	}
	
	
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio15Criteria   CriteriaEjercicio15 = new Ejercicio15Criteria();
		 
		 CriteriaEjercicio15.Listar();
		 
	}
	
}
