package org.sistema.hibernate.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="Factura")
public class Factura {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "numeroFactura", nullable= false)
	private String numeroFactura;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Cliente cliente;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "factura_producto", joinColumns ={
			@JoinColumn(name = "facturaId", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name= "productoId",referencedColumnName ="id")} )
	private List<Producto> listaProductos = new ArrayList<Producto>();

	@Column(name= "fechaFactura")
	private Date fechaFactura;

	@Column(name= "precioTotal")
	private BigDecimal  precioTotal;

	@Column(name= "precioTotalSinIVA")
	private BigDecimal  precioTotalSinIVA;
	
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura( String numeroFactura, Cliente cliente, List<Producto> listaProductos,
			Date fechaFactura, BigDecimal precioTotal, BigDecimal precioTotalSinIVA) {
		super();		
		this.numeroFactura = numeroFactura;
		this.cliente = cliente;
		this.listaProductos = listaProductos;
		this.fechaFactura = fechaFactura;
		this.precioTotal = precioTotal;
		this.precioTotalSinIVA = precioTotalSinIVA;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public BigDecimal getPrecioTotalSinIVA() {
		return precioTotalSinIVA;
	}

	public void setPrecioTotalSinIVA(BigDecimal precioTotalSinIVA) {
		this.precioTotalSinIVA = precioTotalSinIVA;
	}

}
