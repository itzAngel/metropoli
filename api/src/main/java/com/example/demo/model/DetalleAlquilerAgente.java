package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_alquiler_agente")
public class DetalleAlquilerAgente {
	@Id
    @Column(name = "iddetallealquileragente", length = 32)
    private String idDetalleAlquilerAgente;
    
    @ManyToOne()
    @JoinColumn(name = "idalquiler", nullable = true)
    private Alquiler alquiler;
    
    @ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @Column(name = "comision", length = 200)
	private double comision;

	public DetalleAlquilerAgente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleAlquilerAgente() {
		return idDetalleAlquilerAgente;
	}

	public void setIdDetalleAlquilerAgente(String idDetalleAlquilerAgente) {
		this.idDetalleAlquilerAgente = idDetalleAlquilerAgente;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
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
