package com.curso.hibernate.app_Hibernate.Anotaciones.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="direccion",catalog = "curso_hibernate_user")
public class Direcciones implements java.io.Serializable {

	
	@Id
	@GeneratedValue
	@Column(name="idCliente")
	private Integer idCliente;
	
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)  
	@JoinColumn(name="idCliente", nullable=false)
	@PrimaryKeyJoinColumn
	private Clientes cliente;
	
	
	
	@Column(name="calle")
	private String calle;
	
	

	@Column(name="dp")
	private String dp;
	
	
	@Column(name="poblacion")
	private String poblacion;
	
	
	
	@Column(name="provincia")
	private String provincia;

	public Direcciones() {
	}

	public Direcciones(Clientes cliente, String calle, String poblacion, String provincia) {
		this.cliente = cliente;
		this.calle = calle;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public Direcciones(Clientes cliente, String calle, String dp, String poblacion, String provincia) {
		this.cliente = cliente;
		this.calle = calle;
		this.dp = dp;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Clientes getCliente() {
		return this.cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getDp() {
		return this.dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
