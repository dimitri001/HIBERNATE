package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio8Criteria {
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void Listar(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	  // Utilizando la Restrictions.like que encuentre en los registros que comiencen por Camisa y hace un 
	  // inner join  Con esta operación se calcula el producto cruzado de todos los registros; así cada registro en la tabla A (producto) es combinado 
	  // con cada registro de la tabla B(cliente); pero sólo permanecen aquellos registros en la tabla combinada que satisfacen las condiciones que se especifiquen. 
	  // Este es el tipo de JOIN más utilizado, por lo que es considerado el tipo de combinación predeterminado.
	  
	     
	   // LEFT OUTER JOIN retorna la pareja de todos los valores de la tabla izquierda(Cliente) con los valores de la 
	  //  tabla de la derecha(Producto) correspondientes, o retorna un valor nulo NULL en caso de no correspondencia.EAGER esta deprecated
	     
	  // los setFetchMode() siempre se refieren a la entidad definida en el último createCriteria    
	     
	     
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add( Restrictions.like("nombre", "%azul%") )
	     .setFetchMode("cliente", FetchMode.EAGER)
	    .list();  
	     
	  
	     
	     
	     
	     List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio8Criteria------------------------------------------------------" );
		  
			
			System.out.println("NOMBRE PRODUCTO                       CANTIDADES                    NOMBRES                                 APELLIDOS" );
		    System.out.println("-----------------                     -----------                  ----------                               ----------");
		   
		    for (Producto producto : productos) {
		      
		    	 System.out.println( producto.getNombre()+"              "+producto.getCantidades()
			    	+"                "+producto.getCliente().getNombre()+"                     "+producto.getCliente().getApellidos()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );

	     
	  } 



      public static void main(String[] args) { 	 
	 
	   Ejercicio8Criteria  CriteriaEjercicio8 = new Ejercicio8Criteria();
	   CriteriaEjercicio8.Listar();
	 
}


}
