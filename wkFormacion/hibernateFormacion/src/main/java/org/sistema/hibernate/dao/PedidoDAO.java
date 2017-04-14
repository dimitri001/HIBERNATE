package org.sistema.hibernate.dao;

import java.util.List;

import org.sistema.hibernate.models.Pedido;

public class PedidoDAO extends GenericDAO<Pedido> {

	public PedidoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Pedido> findAll(){
		return super.findAll(Pedido.class);
	}
	
}
