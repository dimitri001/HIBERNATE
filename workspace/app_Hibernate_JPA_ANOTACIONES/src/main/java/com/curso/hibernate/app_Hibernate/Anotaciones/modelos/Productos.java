package com.curso.hibernate.app_Hibernate.Anotaciones.modelos;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="producto",catalog = "curso_hibernate_user")

public class Productos implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idProducto")
	private Integer idProducto;
	
	
	
	@Column(name="nombre")
	private String nombre;
	
	
	
	@Column(name="cantidades")
	private int cantidades;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Clientes cliente;
	
	
	
		
	
	public Productos() {
	}
	
	
	
	public Integer getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCantidades() {
		return cantidades;
	}



	public void setCantidades(int cantidades) {
		this.cantidades = cantidades;
	}



	public Productos( Clientes cliente, String nombre, int cantidades) {
		//this.idProducto = 123;
		this.cliente = cliente;
		this.nombre = nombre;
		this.cantidades = cantidades;
	}



	

}






