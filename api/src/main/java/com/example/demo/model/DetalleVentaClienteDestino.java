package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta_cliente_destino")
public class DetalleVentaClienteDestino {
	@Id
    @Column(name = "iddetalleventaclientedestino", length = 32)
    private String idDetalleVentaClienteDestino;
    
    @ManyToOne()
    @JoinColumn(name = "idventa", nullable = true)
    private Venta venta;
    
    @ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;

	public DetalleVentaClienteDestino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleVentaClienteDestino() {
		return idDetalleVentaClienteDestino;
	}

	public void setIdDetalleVentaClienteDestino(String idDetalleVentaClienteDestino) {
		this.idDetalleVentaClienteDestino = idDetalleVentaClienteDestino;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
	
}
