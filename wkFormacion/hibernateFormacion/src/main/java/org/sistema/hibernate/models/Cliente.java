package org.sistema.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Cliente")
public class Cliente{
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;

	@Embedded
	private Persona persona;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String nombre, String apellidos, String dni, Integer edad, String direccion) {
		super();
		persona = new Persona(nombre,  apellidos,  dni, edad, direccion);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
