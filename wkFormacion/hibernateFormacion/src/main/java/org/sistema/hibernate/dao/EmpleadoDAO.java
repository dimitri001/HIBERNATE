package org.sistema.hibernate.dao;

import java.util.List;

import org.sistema.hibernate.models.Cliente;
import org.sistema.hibernate.models.Empleado;

public class EmpleadoDAO extends GenericDAO<Empleado> {

	public EmpleadoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Empleado> findAll(){
		return super.findAll(Empleado.class);
	}

	
}
