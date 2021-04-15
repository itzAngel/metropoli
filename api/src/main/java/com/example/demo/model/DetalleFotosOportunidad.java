package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_fotos_oportunidad")
public class DetalleFotosOportunidad {
	@Id
    @Column(name = "iddetalle", length = 32)
    private String idDetalle;
	
	@ManyToOne()
    @JoinColumn(name = "idoportunidad", nullable = true)
    private OportunidadInversion oportunidad;
	
	@ManyToOne()
    @JoinColumn(name = "idimagen", nullable = true)
    private Imagen foto;
	
	public DetalleFotosOportunidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
	}

	public OportunidadInversion getOportunidad() {
		return oportunidad;
	}

	public void setOportunidad(OportunidadInversion oportunidad) {
		this.oportunidad = oportunidad;
	}

	public Imagen getFoto() {
		return foto;
	}

	public void setFoto(Imagen foto) {
		this.foto = foto;
	}
    
	
}
