package org.sistema.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="TipoProducto")
public class TipoProducto {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "codigoTipo", nullable= false)
	private String codigoTipo;
	
	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "descripcion")
	private String descripcion;

	public TipoProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoProducto(String codigoTipo, String nombre, String descripcion) {
		super();
		this.codigoTipo = codigoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
