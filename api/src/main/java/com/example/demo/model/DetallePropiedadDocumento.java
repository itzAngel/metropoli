package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_propiedad_documentos")
public class DetallePropiedadDocumento {
	@Id
    @Column(name = "iddetallepropiedaddocumentos", length = 32)
    private String idDetallePropiedadDocumentos;
	
	@ManyToOne()
    @JoinColumn(name = "iddocumento", nullable = true)
    private Documento documento;
	
	@ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;

	public DetallePropiedadDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetallePropiedadDocumentos() {
		return idDetallePropiedadDocumentos;
	}

	public void setIdDetallePropiedadDocumentos(String idDetallePropiedadDocumentos) {
		this.idDetallePropiedadDocumentos = idDetallePropiedadDocumentos;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	
}
