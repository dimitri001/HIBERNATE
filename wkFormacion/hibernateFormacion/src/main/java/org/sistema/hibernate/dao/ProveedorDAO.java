package org.sistema.hibernate.dao;

import java.util.List;

import org.sistema.hibernate.models.Proveedor;

public class ProveedorDAO extends GenericDAO<Proveedor> {

	public ProveedorDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Proveedor> findAll(){
		return super.findAll(Proveedor.class);
	}

	
}
