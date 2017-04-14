package com.curso.hibernate.app_Hibernate.Anotaciones.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="correoelectronico",catalog = "curso_hibernate_user")
//public class CorreoElctronico implements java.io.Serializable {
public class CorreoElctronico {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="idCorreoelectronico")
	private Integer idCorreoelectronico;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCliente", nullable = false)
	
	private Clientes cliente;
	
	
	
	
	private String correoelectronico;
	
	

	
	public CorreoElctronico(Clientes cliente, String correoelectronico) {
		this.cliente = cliente;
		this.correoelectronico = correoelectronico;
	}

	public Integer getIdCorreoelectronico() {
		return this.idCorreoelectronico;
	}

	public void setIdCorreoelectronico(Integer idCorreoelectronico) {
		this.idCorreoelectronico = idCorreoelectronico;
	}

	public Clientes getCliente() {
		return this.cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	
	public CorreoElctronico() {
	}

}

