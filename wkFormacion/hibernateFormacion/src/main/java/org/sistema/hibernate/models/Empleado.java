package org.sistema.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="Empleado")
public class Empleado extends Persona {

	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "numEmpleado", nullable= false)
	private String numEmpleado;
	
	@Column(name= "puesto")
	private String puesto;
	
	@Embedded
	private Persona persona;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(String numEmpleado, String puesto, String nombre, String apellidos, String dni, Integer edad, String direccion) {
		super();
		this.numEmpleado = numEmpleado;
		this.puesto = puesto;
		persona = new Persona(nombre,  apellidos,  dni, edad, direccion);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
}
