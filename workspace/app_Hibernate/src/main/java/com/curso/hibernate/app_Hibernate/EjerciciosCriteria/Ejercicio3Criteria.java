package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;



public class Ejercicio3Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	
	public void ListarMetodoChainig(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	   
	     
	     // Ejemplo que muestra el el registro que primer encuentra con el nombre Camisa ..., con unico resultado   
	        
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.add(Restrictions.eq("nombre", "Camisa Roja Caballero"));
	     cr.setMaxResults(1);
	     cr.uniqueResult();
	    
	   
	    
		    List<Producto> productos = cr.list();
			System.out.println("---------------------------------------------Ejercicio3Criteria------------------------------------------------------" );
		    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
		    System.out.println("---------       ----------         ------                               ----------");
		    for (Producto producto : productos) {
		      
		    	 System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
			    	+"                "+producto.getNombre()+"                  "+producto.getCantidades()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );
	  } 
	
	
		
	
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio3Criteria   CriteriaEjercicio3 = new Ejercicio3Criteria();
		 
		 CriteriaEjercicio3.ListarMetodoChainig();
	}
	

}
