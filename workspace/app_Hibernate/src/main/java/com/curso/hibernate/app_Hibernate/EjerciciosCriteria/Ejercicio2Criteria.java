package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;



import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;


import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio2Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}

	
	/*
	 *  Ejemplo de add Order ordenando ascendentemente los registros:
	 * 
	 */	
		
	
	public void ListarAscendentementeCantidades(){ 
		 
	 Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	 Criteria cr = session.createCriteria(Producto.class);
	 cr.addOrder(Order.asc("cantidades"));
	         
	 // otro ejemplo descomentar y probar
	     
	 //cr.addOrder(Order.desc("cantidades"));
	    
	     
		    
	     
		    List<Producto> productos = cr.list();
		    System.out.println("---------------------------------------------Ejercicio2Criteria------------------------------------------------------" );
		    System.out.println("IdCLIENTE       IdPRODUCTO         NOMBRE                               CANTIDADES");
		    System.out.println("---------       ----------         ------                               ----------");
		    for (Producto producto : productos) {
		    	
		    	 System.out.println(producto.getCliente().getIdCliente()+"                "+producto.getIdProducto()
			    	+"                "+producto.getNombre()+"               "+producto.getCantidades()+"\n");
			    	
		     }

		    System.out.println("--------------------------------------------------------------------------------------------------------------------" );
	  } 
	
	public static void main(String[] args) { 	 
		 
		 Ejercicio2Criteria   CriteriaEjercicio2 = new Ejercicio2Criteria();
		 
		 CriteriaEjercicio2.ListarAscendentementeCantidades();
	}
	


}
