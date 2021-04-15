package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "DETALLE_PEDIDO_UBICACION")
public class DetallePedidoUbicacion {
	@Id
    @Column(name = "iddetallepedidoubicacion", length = 32)
    private String idDetallePedidoUbicacion;
    
    @ManyToOne()
    @JoinColumn(name = "idubicacion", nullable = true)
    private Ubicacion ubicacion;
    
    @ManyToOne()
    @JoinColumn(name = "idpedido", nullable = true)
    private Pedido pedido;

	public DetallePedidoUbicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetallePedidoUbicacion() {
		return idDetallePedidoUbicacion;
	}

	public void setIdDetallePedidoUbicacion(String idDetallePedidoUbicacion) {
		this.idDetallePedidoUbicacion = idDetallePedidoUbicacion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
    
	
}
