package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;
import org.hibernate.criterion.Property;

// Proyecciones, agregación y agrupamiento


public class Ejercicio14Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
		 
	     
	
			
		
	  Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	  Criteria cr = session.createCriteria(Producto.class);
	  cr.setProjection( Property.forName("nombre") )
	  .add( Property.forName("nombre").like("%Camisa%"))
	  .add( Property.forName("cantidades").between(10,46))
	  .addOrder( Order.asc("nombre") );

	   System.out.println("---------------------------------------------EJERCICIO NUMERO 14 Criteria------------------------------------------------------" );
		  for(int i=0; i< cr.list().size(); i++) {   
			 
		       System.out.println("VALOR --> " + cr.list().get(i).toString());  
		    	
		    }
		  System.out.println("-----------------------------------------------------------------------------------------------------------------------------" );
	
	}


	 public static void main(String[] args) { 	 
	 
	 Ejercicio14Criteria   CriteriaEjercicio14 = new Ejercicio14Criteria();
	 CriteriaEjercicio14.Listar();
}



}
