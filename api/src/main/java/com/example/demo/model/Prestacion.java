package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prestacion")
public class Prestacion {
	@Id
    @Column(name = "idprestacion", length = 32)
    private String idPrestacion;
    
    @Column(name = "servicio", length = 150)
	private String servicio;
    
    @Column(name = "descripcion", length = 150)
	private String descripcion;

	public Prestacion() {
		super();
	}

	public Prestacion(String idPrestacion, String servicio, String descripcion) {
		super();
		this.idPrestacion = idPrestacion;
		this.servicio = servicio;
		this.descripcion = descripcion;
	}

	public String getIdPrestacion() {
		return idPrestacion;
	}

	public void setIdPrestacion(String idPrestacion) {
		this.idPrestacion = idPrestacion;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Prestacion [idPrestacion=" + idPrestacion + ", servicio=" + servicio + ", descripcion=" + descripcion
				+ "]";
	}
    
}
