package com.curso.hibernate.app_Hibernate.SQLNativo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.curso.hibernate.app_Hibernate.EjerciciosCriteria.Ejercicio16Criteria;
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
		 @SuppressWarnings("unchecked")
		List<Object> productos= (List<Object>)session.createSQLQuery("SELECT * FROM PRODUCTO").list();
		 Iterator itr0 = productos.iterator();
	
		 
		 System.out.print(" ***************************Ejercicio1SQLNativo********************************* "+ "'\n'"); 
		 while(itr0.hasNext()){
		    Object[] obj = (Object[]) itr0.next();
		    //now you have one array of Object for each row
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    String idProducto = String.valueOf(obj[0]); // 
		    System.out.print("  idProducto: " +   idProducto.toString()+"'\n'"); 
		    String nombre = String.valueOf(obj[1]); // 
		    System.out.print("  nombre: " +   nombre.toString()+ "'\n'");
		    String cantidades = String.valueOf(obj[2]); // 
		    System.out.print("  Cantidades: " +   cantidades.toString()+ "'\n'");
		    String idCliente = String.valueOf(obj[3]); 
		    System.out.print("  idCliente: " +   idCliente.toString()+ "'\n'");
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		 }
		 
		 
		 
		 
		@SuppressWarnings("unchecked")
		List <Object>productos2=  (List<Object>)session.createSQLQuery("SELECT IDPRODUCTO,IDCLIENTE, NOMBRE FROM PRODUCTO").list();
		
		 
		
		 Iterator itr = productos2.iterator();
		 while(itr.hasNext()){
		    Object[] obj = (Object[]) itr.next();
		    //now you have one array of Object for each row
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    String idProducto = String.valueOf(obj[0]); // 
		    System.out.print("  idProducto: " +   idProducto.toString()+"'\n'"); 
		    String idCliente = String.valueOf(obj[1]); 
		    System.out.print("  Nombre: " +   idCliente.toString()+ "'\n'");
		    String nombre = String.valueOf(obj[2]); // 
		    System.out.print("  nombre: " +   nombre.toString()+ "'\n'");
		    System.out.print(" ************************************************************ "+ "'\n'"); 
		    
		 }
	  
		 
		
		 
	}
	
	

	public static void main(String[] args) { 	 
		 
		Ejercicio1SQLNativo   EjercicioSQLNativo1 = new Ejercicio1SQLNativo();
		 
		EjercicioSQLNativo1.Ejercicio1SQLNativo();
	}

}
