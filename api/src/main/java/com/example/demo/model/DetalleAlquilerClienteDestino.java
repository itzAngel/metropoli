package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_alquiler_cliente_destino")
public class DetalleAlquilerClienteDestino {
	@Id
    @Column(name = "iddetallealquilerclientedestino", length = 32)
    private String idDetalleAlquilerClienteDestino;
    
    @ManyToOne()
    @JoinColumn(name = "idalquiler", nullable = true)
    private Alquiler alquiler;
    
    @ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;

	public DetalleAlquilerClienteDestino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleAlquilerClienteDestino() {
		return idDetalleAlquilerClienteDestino;
	}

	public void setIdDetalleAlquilerClienteDestino(String idDetalleAlquilerClienteDestino) {
		this.idDetalleAlquilerClienteDestino = idDetalleAlquilerClienteDestino;
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
