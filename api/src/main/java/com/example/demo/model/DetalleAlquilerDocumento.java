package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_alquiler_documento")
public class DetalleAlquilerDocumento {
	@Id
    @Column(name = "iddetalledocumentoalquiler", length = 32)
    private String idDetalleDocumentoAlquiler;
    
    @ManyToOne()
    @JoinColumn(name = "idalquiler", nullable = true)
    private Alquiler alquiler;
    
    @ManyToOne()
    @JoinColumn(name = "iddocumento", nullable = true)
    private Documento documento;

	public DetalleAlquilerDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleDocumentoAlquiler() {
		return idDetalleDocumentoAlquiler;
	}

	public void setIdDetalleDocumentoAlquiler(String idDetalleDocumentoAlquiler) {
		this.idDetalleDocumentoAlquiler = idDetalleDocumentoAlquiler;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
    
	
}
