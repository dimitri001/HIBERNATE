package com.curso.hibernate.app_Hibernate.Modelos;
// Generated 05-may-2016 15:33:09 by Hibernate Tools 3.4.0.CR1

/**
 * Direccionpersona generated by hbm2java
 */
public class Direccionpersona implements java.io.Serializable {

	private Integer direccionId;
	private int personaId;
	private String calle;
	private String ciudad;
	private String provincia;

	public Direccionpersona() {
	}

	public Direccionpersona(int personaId, String calle, String ciudad, String provincia) {
		this.personaId = personaId;
		this.calle = calle;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}

	public Integer getDireccionId() {
		return this.direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public int getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}