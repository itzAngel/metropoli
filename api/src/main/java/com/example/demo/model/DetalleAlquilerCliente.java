package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_alquiler_cliente")
public class DetalleAlquilerCliente {
	@Id
    @Column(name = "iddetallealquilercliente", length = 32)
    private String idDetalleAlquilerCliente;
    
    @ManyToOne()
    @JoinColumn(name = "idalquiler", nullable = true)
    private Alquiler alquiler;
    
    @ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;

	public DetalleAlquilerCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleAlquilerCliente() {
		return idDetalleAlquilerCliente;
	}

	public void setIdDetalleAlquilerCliente(String idDetalleAlquilerCliente) {
		this.idDetalleAlquilerCliente = idDetalleAlquilerCliente;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
}
