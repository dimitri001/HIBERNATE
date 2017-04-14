package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import com.curso.hibernate.app_Hibernate.Modelos.Cliente;
import com.curso.hibernate.app_Hibernate.Modelos.Producto;
import com.curso.hibernate.app_Hibernate.configuracionSesion.Configuracion;

public class Ejercicio1SQLNativo {
	
	public Configuracion SesionHibernate()
	{
		
		Configuracion sesionEntrono = new Configuracion();
		return sesionEntrono;
		
		
	}
	

	public void Ejercicio1SQLNativo(){ 
	    
		// consulta SQL más básica es para obtener a una lista de escalares (valores).
		
		@SuppressWarnings("unchecked")

		Session session =  SesionHibernate().getSessionFactory().openSession(); 
		
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio1SQLNativo   EjercicioSQLNativo1 = new Ejercicio1SQLNativo();
		 
		EjercicioSQLNativo1.Ejercicio1SQLNativo();
	}

}
