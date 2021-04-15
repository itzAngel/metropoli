package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta_documento")
public class DetalleVentaDocumento {
	@Id
    @Column(name = "iddetalledocumentoventa", length = 32)
    private String idDetalleDocumentoVenta;
    
    @ManyToOne()
    @JoinColumn(name = "idventa", nullable = true)
    private Venta venta;
    
    @ManyToOne()
    @JoinColumn(name = "iddocumento", nullable = true)
    private Documento documento;

	public DetalleVentaDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDetalleDocumentoVenta() {
		return idDetalleDocumentoVenta;
	}

	public void setIdDetalleDocumentoVenta(String idDetalleDocumentoVenta) {
		this.idDetalleDocumentoVenta = idDetalleDocumentoVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
    
	
}
