package com.curso.hibernate.app_Hibernate.EjerciciosCriteria;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;
import org.hibernate.criterion.Projections;



public class Ejercicio13Criteria {
	
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	
	public void Listar(){ 
		 
	     
	
			
		
		Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     Criteria cr = session.createCriteria(Producto.class);
	     cr.setProjection( Projections.projectionList()
	     .add( Projections.rowCount(), "camisaCountByColor" )
	     .add( Projections.avg("cantidades"), "avgValor" )
	     .add( Projections.max("cantidades"), "maxValor" )
	     .add( Projections.groupProperty("nombre"), "nombre" ))
	     .addOrder( Order.desc("camisaCountByColor") )
		 .addOrder( Order.desc("avgValor") )
		 .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
           
	     System.out.println("---------------------------------------------EJERCICIO NUMERO 13 Criteria------------------------------------------------------" );
	    
	     
	     
	      for(int i=0; i< cr.list().size(); i++) {     
		   	
	    	  System.out.println("----------------------------------------------------RESULTADO----------------------------------------------------------------" );
			  System.out.println("VALOR " + cr.list().get(i).toString());  
			  System.out.println("-----------------------------------------------------------------------------------------------------------------------------" );
		    }
		    
		   System.out.println("-----------------------------------------------------------------------------------------------------------------------------" );
	
	}

    public static void main(String[] args) { 	 
	 
	 Ejercicio13Criteria   CriteriaEjercicio13 = new Ejercicio13Criteria();
	 CriteriaEjercicio13.Listar();
	 
}



}
