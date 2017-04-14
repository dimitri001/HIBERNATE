package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio10Criteria {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void Listar(){ 
		 
	Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	Criteria cr = session.createCriteria(Producto.class);
	cr.add( Restrictions.like("nombre", "%azul%") )
	.setFetchMode("cliente", FetchMode.SELECT)
	.list();  
	     
	     
	     
	     System.out.println("                                                                                                                         " );
	     List<Producto> productos = cr.list();
	     
	     
	     System.out.println("---------------------------------------------Ejercicio10Criteria------------------------------------------------------" );
			
			
		    System.out.println("NOMBRE PRODUCTO                       CANTIDADES                    NOMBRES                                 APELLIDOS" );
		    System.out.println("-----------------                     -----------                  ----------                               ----------");
		   
		    for (Producto producto : productos) {
		      
		    	 System.out.println( producto.getNombre()+"              "+producto.getCantidades()
			    	+"                "+producto.getCliente().getNombre()+"                     "+producto.getCliente().getApellidos()+"\n");
		      
		     }
		    
		    System.out.println("---------------------------------------------------------------------------------------------------------------------" );

	     
	  } 

public static void main(String[] args) { 	 
	 
	Ejercicio10Criteria   CriteriaEjercicio10 = new Ejercicio10Criteria();
	 
	CriteriaEjercicio10.Listar();
	 
}


}
