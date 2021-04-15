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
@Table(name = "asigna_propiedad_cliente")
public class AsignaPropiedadCliente {
	@Id
    @Column(name = "idasignapropiedad", length = 32)
    private String idAsignaPropiedad;
	
	@ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;
	
	@ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechainicio")
    private Date fechaInicio;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechafin")
    private Date fechaFin;

	public AsignaPropiedadCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdAsignaPropiedad() {
		return idAsignaPropiedad;
	}

	public void setIdAsignaPropiedad(String idAsignaPropiedad) {
		this.idAsignaPropiedad = idAsignaPropiedad;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
