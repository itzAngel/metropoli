package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_fotos_propiedad")
public class DetalleFotosPropiedad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "iddetalleimagenpropiedad", length = 32)
    private String idDetalleFotosPropiedad;
    
    @Column(name = "idimagen")
    private String foto;
    
    @ManyToOne()
    @JoinColumn(name = "idpropiedad",referencedColumnName = "idpropiedad")
    private Propiedad propiedad;

	public DetalleFotosPropiedad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleFotosPropiedad() {
		return idDetalleFotosPropiedad;
	}

	public void setIdDetalleFotosPropiedad(String idDetalleFotosPropiedad) {
		this.idDetalleFotosPropiedad = idDetalleFotosPropiedad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
    
    
}
