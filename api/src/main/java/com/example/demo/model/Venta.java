package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
    @Column(name = "idventa", length = 32)
    private String idVenta;
	
	@ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechacontrato")
    private Date fechaContrato;
	
	@ManyToOne()
	@JoinColumn(name = "idmoneda")
	private Moneda moneda;
    
	@Column(name = "precio", length = 200)
	private double precio;
	
    @Column(name = "tipocomision", length = 200)
	private String tipoComision;
    
    @Column(name = "comisiontotal", length = 200)
	private double comisionTotal;
    
    @Column(name = "comentario", length = 500)
	private String comentario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetalleVentaAgente> listaDetalleVentaAgente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetalleVentaCliente> listaDetalleVentaCliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetalleVentaClienteDestino> listaDetalleVentaClienteDestino;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<DetalleVentaDocumento> listaDetalleVentaDocumento;

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(String idVenta, Propiedad propiedad, Date fechaContrato, Moneda moneda, double precio,
			String tipoComision, double comisionTotal, String comentario) {
		super();
		this.idVenta = idVenta;
		this.propiedad = propiedad;
		this.fechaContrato = fechaContrato;
		this.moneda = moneda;
		this.precio = precio;
		this.tipoComision = tipoComision;
		this.comisionTotal = comisionTotal;
		this.comentario = comentario;
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipoComision() {
		return tipoComision;
	}

	public void setTipoComision(String tipoComision) {
		this.tipoComision = tipoComision;
	}

	public double getComisionTotal() {
		return comisionTotal;
	}

	public void setComisionTotal(double comisionTotal) {
		this.comisionTotal = comisionTotal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
    
}
