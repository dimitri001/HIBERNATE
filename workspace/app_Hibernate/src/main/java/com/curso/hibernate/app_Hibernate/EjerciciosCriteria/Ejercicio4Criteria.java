package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Property;


import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio4Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
	}
	
	
	
	public void ListarProperty(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     // Ejemplo que Utiliza la poropiedad por nombre de campo (Property.forName)   
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add(Property.forName("nombre").eq("Camisa Roja Caballero"));
	    
	     
	        
	     // Ejemplo que Utiliza la poropiedad setProjection diferenetes ejeeplos, comentar el for para ejecutar da fallo
	     // Para ver el resultado descomentar el sytem.out
		   
	     
	       // total registros.
		    // cr.setProjection(Projections.rowCount());
		    // List rowCount = cr.list();
		    // System.out.println("Total Coint: " + rowCount.get(0) );
		   
		    // Para saber la media de las cantidades.
		    // cr.setProjection(Projections.avg("cantidades"));
	        // List rowCount = cr.list();
		    // System.out.println("Media: " + rowCount.get(0) );
		     

		     // Para comntar los distintos nombre de productos 
		     //   cr.setProjection(Projections.countDistinct("nombre"));
	         // List rowCount = cr.list();
		    // System.out.println("Total distintos: " + rowCount.get(0) );
	     
		     // Para saber la maxima cantidad
		     //cr.setProjection(Projections.max("cantidades"));
	         // List rowCount = cr.list();
		    // System.out.println("Máxima cantidad: " + rowCount.get(0) );
	     
	     
		     // para saber la minima cantidad
		     //cr.setProjection(Projections.min("cantidades"));
	         // List rowCount = cr.list();
		    // System.out.println("Mínima cantidad: " + rowCount.get(0) );
	     

		     // Para saber la suma de las cantidades
		     //cr.setProjection(Projections.sum("cantidades"));  
	         // List rowCount = cr.list();
		    // System.out.println("Suma de cantidades: " + rowCount.get(0) );
	     
	        
	     List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio4Criteria------------------------------------------------------" );
		    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
		    System.out.println("---------       ----------         ------                               ----------");
		    for (Producto producto : productos) {
		      
		    	 System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
			    	+"                "+producto.getNombre()+"                  "+producto.getCantidades()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
  
	  } 
	
	
	
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio4Criteria   CriteriaEjercicio4 = new Ejercicio4Criteria();
		 
		 CriteriaEjercicio4.ListarProperty();
	}
	

}
