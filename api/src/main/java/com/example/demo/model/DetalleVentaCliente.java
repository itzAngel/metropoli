package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta_cliente")
public class DetalleVentaCliente {
	@Id
    @Column(name = "iddetalle", length = 32)
    private String idDetalle;
    
    @ManyToOne()
    @JoinColumn(name = "idventa", nullable = true)
    private Venta venta;
    
    @ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;

	public DetalleVentaCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
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
