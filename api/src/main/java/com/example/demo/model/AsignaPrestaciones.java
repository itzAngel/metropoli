package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asigna_prestaciones")
public class AsignaPrestaciones {
	@Id
    @Column(name = "idasignaprestacion", length = 32)
    private String idAsignaPrestacion;
    
    @ManyToOne()
    @JoinColumn(name = "idprestacion", nullable = true)
    private Prestacion prestacion;
    
    @ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;

	public String getIdAsignaPrestacion() {
		return idAsignaPrestacion;
	}

	public void setIdAsignaPrestacion(String idAsignaPrestacion) {
		this.idAsignaPrestacion = idAsignaPrestacion;
	}

	public Prestacion getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(Prestacion prestacion) {
		this.prestacion = prestacion;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
    
    
}
