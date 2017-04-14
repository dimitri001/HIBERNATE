package org.sistema.hibernate.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "codigo", nullable= false)
	private String codigo;
	
	@Column(name= "precioCompra")
	private BigDecimal  precioCompra;
	
	@Column(name= "precioVenta")
	private BigDecimal  precioVenta;
	
	@Column(name= "stock")
	private Integer stock;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipoProducto")
	private TipoProducto tipoProducto;
	
	@Column(name= "descripcion")
	private String descripcion;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String codigo, BigDecimal precioCompra, BigDecimal precioVenta, Integer stock,
			TipoProducto tipoProducto, String descripcion) {
		super();
		this.codigo = codigo;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.tipoProducto = tipoProducto;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
