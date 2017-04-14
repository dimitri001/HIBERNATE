package org.sistema.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="Proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@Column(name= "nombre")
	private String nombre;
	
	@NotNull
	@Column(name= "cif", nullable= false)
	private String cif;
	
	@Column(name= "direccion")
	private String direccion;

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(String nombre, String cif, String direccion) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
