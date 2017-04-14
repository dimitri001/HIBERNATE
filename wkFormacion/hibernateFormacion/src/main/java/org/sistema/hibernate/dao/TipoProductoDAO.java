package org.sistema.hibernate.dao;

import java.util.List;

import org.sistema.hibernate.models.TipoProducto;

public class TipoProductoDAO  extends GenericDAO<TipoProducto> {

	public TipoProductoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<TipoProducto> findAll(){
		return super.findAll(TipoProducto.class);
	}

}
