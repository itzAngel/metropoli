package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta_agente")
public class DetalleVentaAgente {
	@Id
    @Column(name = "iddetalle", length = 32)
    private String idDetalle;
    
    @ManyToOne()
    @JoinColumn(name = "idventa", nullable = true)
    private Venta venta;
    
    @ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @Column(name = "comision", length = 200)
	private double comision;

	public DetalleVentaAgente() {
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

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
    
	
}
