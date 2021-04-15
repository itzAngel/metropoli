package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "asigna_agencia")
public class AsignaAgencia {
	@Id
    @Column(name = "idasignaagencia", length = 32)
    private String idAsignaAgencia;
	
	@ManyToOne()
    @JoinColumn(name = "idagencia", nullable = true)
    private Agencia agencia;
	
	@ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechainicio")
    private Date fechaInicio;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechafin")
    private Date fechaFin;

	public AsignaAgencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdAsignaAgencia() {
		return idAsignaAgencia;
	}

	public void setIdAsignaAgencia(String idAsignaAgencia) {
		this.idAsignaAgencia = idAsignaAgencia;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
