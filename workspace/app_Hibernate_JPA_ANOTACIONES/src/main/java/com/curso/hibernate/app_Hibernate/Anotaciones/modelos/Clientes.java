package com.curso.hibernate.app_Hibernate.Anotaciones.modelos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="cliente",catalog = "curso_hibernate_user")
public class Clientes implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idCliente")
	private Integer idCliente;
	
	

	@Column(name="nombre")
	private String nombre;
	
	
	//@GeneratedValue
	@Column(name="apellidos")
	private String apellidos;
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Productos>productos = new HashSet(0);
	
	
	//@OneToMany
	//@JoinColumn(name="idCliente")
	private Direcciones direccion;
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "cliente") 
	private Set<CorreoElctronico>correoelectronico = new HashSet(0);

	
	
	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Set getProductos() {
		return this.productos;
	}

	//public void setProductos(Set productos) {
	//	this.producto = productos;
	//}
	
	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	    }

	

	public Direcciones getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}

	public Set getCorreoelectronicos() {
		return this.correoelectronico;
	}

	public void setCorreoelectronicos(Set<CorreoElctronico> correoelectronicos) {
		this.correoelectronico = correoelectronicos;
	}
	

public Clientes() {
}

public Clientes(int id ,String nombre, String apellidos) {
	this.idCliente = id;
	this.nombre = nombre;
	this.apellidos = apellidos;
}

public Clientes(String nombre, String apellidos, Set productos, Direcciones direccion, Set correoelectronicos) {
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.productos = productos;
	this.direccion = direccion;
	this.correoelectronico = correoelectronicos;
}

}



