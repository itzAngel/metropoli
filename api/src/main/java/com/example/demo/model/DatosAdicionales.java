package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datos_adicionales")
public class DatosAdicionales {
	@Id
    @Column(name = "iddatoadicional", length = 32)
    private String idDatoAdicional;
    
    @Column(name = "titulo", length = 150)
	private String titulo;
    
    @Column(name = "descripcion", length = 500)
	private String descripcion;
    
    @ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;

	public String getIdDatoAdicional() {
		return idDatoAdicional;
	}

	public void setIdDatoAdicional(String idDatoAdicional) {
		this.idDatoAdicional = idDatoAdicional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
    
    
}
