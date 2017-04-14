package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio1Criteria {
	
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
/*
 *  Ejemplo de add con una restricción(Restrictions) para devolver los registros con la cantidad que sea igual a 25 uniddes:
 * 
 */	
	
	
 public void Ejercicio1Criteria(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     
	   
	        
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add(Restrictions.eq("cantidades", 25));
	         
	   
	     /*  OTROS EJEMPLOS con Restrictions DESCOMENTAR Y PROBAR */


	  // Para obtener las cantidades inferior a 25
	  // cr.add(Restrictions.lt("cantidades", 25));

	  // Para obtener los registros que contengan la palabra camisa
	  // cr.add(Restrictions.like("nombre", "Camisa%"));

	  // Para obtener los registros que contengan la palabra camisa
	  //  cr.add(Restrictions.ilike("nombre", "Camisa%"));

	   // para obtener los registros que contengan las cantidades entre 5 y 10 unidades
	   // cr.add(Restrictions.between("cantidades", 5, 10));

	   //  para obtener los registros que contengan nulos en cantidades
	  //  cr.add(Restrictions.isNull("cantidades"));

	     
	   //  para obtener los registros que contengan no nulos en cantidades
	  //cr.add(Restrictions.isNotNull("cantidades"));

	  //Para comprobar si la propiedad proporcionada está vacía
	  // cr.add(Restrictions.isEmpty("cantidades"));
	     
	  //   Para comprobar si la propiedad proporcionada no está vacía  
      //  cr.add(Restrictions.isNotEmpty("cantidades"));      
  
	     
	   
	    
	     
	    List<Producto> productos = cr.list();
	  
	    System.out.println("---------------------------------------------Ejercicio1Criteria------------------------------------------------------" );
	    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
	    System.out.println("---------       ----------         ------                               ----------");
	    for (Producto producto : productos) {
	    	
	    	//System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE         CANTIDADES");
	    	System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
	    	+"                "+producto.getNombre()+"           "+producto.getCantidades());
	    	
	         
	     }

	    System.out.println("--------------------------------------------------------------------------------------------------------------------" );
 
}
 
 
 
 public static void main(String[] args) { 	 
	 
	 Ejercicio1Criteria   CriteriaEjercicio1 = new Ejercicio1Criteria();
	 
	 CriteriaEjercicio1.Ejercicio1Criteria();
	 
}

}
