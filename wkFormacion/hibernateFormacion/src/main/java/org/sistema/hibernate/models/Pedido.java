package org.sistema.hibernate.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="Pedido")
public class Pedido {

	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	
	@NotNull
	@Column(name= "numero", nullable= false)
	private String numeroPedido;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pedido_producto", joinColumns ={
			@JoinColumn(name = "pedidoId", referencedColumnName = "id")}, inverseJoinColumns = {
					@JoinColumn(name= "productoId",referencedColumnName ="id")} )
	private List<Producto> listaProductos;
	
	@Column(name= "fecha")	
	private Date fecha;

	@Column(name= "costeTotal")	
	private BigDecimal costeTotal;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;

	@Enumerated(EnumType.STRING)
	private EstadoPedido estadoPedido;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(String numeroPedido, List<Producto> listaProductos, Date fecha, BigDecimal costeTotal,
			Proveedor proveedor, EstadoPedido estadoPedido) {
		super();
		this.numeroPedido = numeroPedido;
		this.listaProductos = listaProductos;
		this.fecha = fecha;
		this.costeTotal = costeTotal;
		this.proveedor = proveedor;
		this.estadoPedido = estadoPedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getCosteTotal() {
		return costeTotal;
	}

	public void setCosteTotal(BigDecimal costeTotal) {
		this.costeTotal = costeTotal;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	
}
