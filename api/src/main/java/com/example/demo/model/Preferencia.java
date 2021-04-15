package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "preferencia")
public class Preferencia {
	@Id
    @Column(name = "idpreferencia", length = 32)
    private String idPreferencia;
    
	@ManyToOne()
	@JoinColumn(name = "idtipo", nullable = true)
	private Tipo tipo;
    
	@ManyToOne()
	@JoinColumn(name = "idestado", nullable = true)
	private Estado estado;
    
	@ManyToOne()
	@JoinColumn(name = "idubicacion", nullable = true)
	private Ubicacion ubicacion;
    
	@ManyToOne()
	@JoinColumn(name = "idmonedamenor", nullable = true)
	private Moneda monedamenor;
    
	@Column(name = "preciomenor", length = 200)
	private double preciomenor;
	
	@ManyToOne()
	@JoinColumn(name = "idmonedamayor", nullable = true)
	private Moneda monedamayor;
    
	@Column(name = "preciomayor", length = 200)
	private double preciomayor;
	
	public Preferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Preferencia(String idPreferencia, Tipo tipo, Estado estado, Ubicacion ubicacion, Moneda monedamenor,
			double preciomenor, Moneda monedamayor, double preciomayor) {
		super();
		this.idPreferencia = idPreferencia;
		this.tipo = tipo;
		this.estado = estado;
		this.ubicacion = ubicacion;
		this.monedamenor = monedamenor;
		this.preciomenor = preciomenor;
		this.monedamayor = monedamayor;
		this.preciomayor = preciomayor;
	}

	public String getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(String idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Moneda getMonedamenor() {
		return monedamenor;
	}

	public void setMonedamenor(Moneda monedamenor) {
		this.monedamenor = monedamenor;
	}

	public double getPreciomenor() {
		return preciomenor;
	}

	public void setPreciomenor(double preciomenor) {
		this.preciomenor = preciomenor;
	}

	public Moneda getMonedamayor() {
		return monedamayor;
	}

	public void setMonedamayor(Moneda monedamayor) {
		this.monedamayor = monedamayor;
	}

	public double getPreciomayor() {
		return preciomayor;
	}

	public void setPreciomayor(double preciomayor) {
		this.preciomayor = preciomayor;
	}

	

}
