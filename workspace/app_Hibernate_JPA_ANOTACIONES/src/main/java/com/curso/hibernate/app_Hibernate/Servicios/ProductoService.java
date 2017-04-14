package com.curso.hibernate.app_Hibernate.Servicios;


import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Clientes;
import com.curso.hibernate.app_Hibernate.Anotaciones.modelos.Productos;


public class ProductoService {

	protected EntityManager prod;

	
	public  ProductoService(EntityManager prod) {
	    this.prod = prod;
	  }

	  public Productos createProducto(Clientes cliente, String nombre, int cantidades) {
		Productos prodt = new Productos(cliente,nombre,cantidades);
	    prodt.setNombre(nombre);
	    prodt.setCantidades(cantidades);
	    prod.persist(prodt);
	    return prodt;
	  }

	  public void removeProducto(int idProducto) {
		  Productos prodt = findProducto(idProducto);
	    if (prodt != null) {
	    	prod.remove(prodt);
	    }
	  }

	  public Productos raiseProductoCantidad(int idProducto, int cantidad) {
		  Productos prodt = prod.find(Productos.class, idProducto);
	    if (prodt != null) {
	    	prodt.setCantidades(prodt.getCantidades() + cantidad);
	    }
	    return prodt;
	  }

	  public Productos findProducto(int idProducto) {
	    return prod.find(Productos.class, idProducto);
	  }

	  public Collection<Productos> findAllProducto() {
	    Query query = prod.createQuery("SELECT e FROM Producto e");
	    return (Collection<Productos>) query.getResultList();
	  }
	

}
