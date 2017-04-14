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
	
	
 public void ListarCantidad(){ 
		 
	     Session session =  SesionHibernate().getSessionFactory().openSession(); 
	    
	     
	   
	     
 
}
 
 
 
 public static void main(String[] args) { 	 
	 
	 Ejercicio1Criteria   CriteriaEjercicio1 = new Ejercicio1Criteria();
	 
	 CriteriaEjercicio1.ListarCantidad();
	 
}

}
