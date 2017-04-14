package org.sistema.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.sun.istack.internal.NotNull;


@Embeddable
public class Persona {

	@Column(name= "nombre")
	private String nombre;
	
	@Column(name= "apellidos")
	private String apellidos;
	
	@NotNull
	@Column(name= "dni", nullable= false)
	private String dni;
	
	@Column(name= "edad")
	private Integer edad;
	
	@Column(name= "direccion")
	private String direccion;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Persona(String nombre, String apellidos, String dni, Integer edad, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.direccion = direccion;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
