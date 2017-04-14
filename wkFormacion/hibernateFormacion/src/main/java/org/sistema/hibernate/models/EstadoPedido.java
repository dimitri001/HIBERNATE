package org.sistema.hibernate.models;

public enum EstadoPedido {
	PEDIDO("pedido"),
	ENVIADO("enviado"),
	ENTREGADO("entregado");
	
	private String value;
	private EstadoPedido(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
}
