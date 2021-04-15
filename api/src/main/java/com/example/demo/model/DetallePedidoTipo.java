package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_pedido_tipo")
public class DetallePedidoTipo {
	@Id
    @Column(name = "iddetalletipo", length = 32)
    private String idDetalleTipo;
    
    @ManyToOne()
    @JoinColumn(name = "idtipo", nullable = true)
    private Tipo tipo;
    
    @ManyToOne()
    @JoinColumn(name = "idpedido", nullable = true)
    private Pedido pedido;

	public DetallePedidoTipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleTipo() {
		return idDetalleTipo;
	}

	public void setIdDetalleTipo(String idDetalleTipo) {
		this.idDetalleTipo = idDetalleTipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
    
	
}
