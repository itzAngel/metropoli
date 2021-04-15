package com.example.demo.model;

import java.util.Date;
import java.util.List;

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
@Table(name = "alquiler")
public class Alquiler {
	@Id
    @Column(name = "idalquiler", length = 32)
    private String idAlquiler;
	
	@ManyToOne()
    @JoinColumn(name = "idpropiedad", nullable = true)
    private Propiedad propiedad;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechacontrato")
    private Date fechaContrato;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechainicio")
    private Date fechaInicio;
	
	@Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechafin")
    private Date fechaFin;
	
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
    
    @OneToMany(mappedBy = "alquiler")
    private List<DetalleAlquilerAgente> listaDetalleAlquilerAgente;

    @OneToMany(mappedBy = "alquiler")
    private List<DetalleAlquilerCliente> listaDetalleAlquilerCliente;
    
    @OneToMany(mappedBy = "alquiler")
    private List<DetalleAlquilerClienteDestino> listaDetalleAlquilerClienteDestino;
    
    @OneToMany(mappedBy = "alquiler")
    private List<DetalleAlquilerDocumento> listaDetalleAlquilerDocumento;
    
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(String idAlquiler, Propiedad propiedad, Date fechaContrato, Date fechaInicio, Date fechaFin,
			Moneda moneda, double precio, String tipoComision, double comisionTotal, String comentario) {
		super();
		this.idAlquiler = idAlquiler;
		this.propiedad = propiedad;
		this.fechaContrato = fechaContrato;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.moneda = moneda;
		this.precio = precio;
		this.tipoComision = tipoComision;
		this.comisionTotal = comisionTotal;
		this.comentario = comentario;
	}

	public String getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(String idAlquiler) {
		this.idAlquiler = idAlquiler;
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
