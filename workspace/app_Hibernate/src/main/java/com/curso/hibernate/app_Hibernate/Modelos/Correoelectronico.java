package com.curso.hibernate.app_Hibernate.Modelos;
// Generated 21-ene-2016 11:09:51 by Hibernate Tools 3.4.0.CR1

/**
 * Correoelectronico generated by hbm2java
 */
public class Correoelectronico implements java.io.Serializable {

	private Integer idCorreoelectronico;
	private Cliente cliente;
	private String correoelectronico;

	public Correoelectronico() {
	}

	public Correoelectronico(Cliente cliente, String correoelectronico) {
		this.cliente = cliente;
		this.correoelectronico = correoelectronico;
	}

	public Integer getIdCorreoelectronico() {
		return this.idCorreoelectronico;
	}

	public void setIdCorreoelectronico(Integer idCorreoelectronico) {
		this.idCorreoelectronico = idCorreoelectronico;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

}