package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seguimiento")
public class Seguimiento {
	@Id
    @Column(name = "idseguimiento", length = 32)
    private String idSeguimiento;
	
	@ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;
	
	@ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @Column(name = "tiposeguimiento", length = 200)
	private String tipoSeguimiento;
    
    @Column(name = "asunto", length = 200)
	private String asunto;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "duracion", length = 150)
	private String duracion;
    
    @Column(name = "comentario", length = 500)
	private String comentario;

	public Seguimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdSeguimiento() {
		return idSeguimiento;
	}

	public void setIdSeguimiento(String idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public String getTipoSeguimiento() {
		return tipoSeguimiento;
	}

	public void setTipoSeguimiento(String tipoSeguimiento) {
		this.tipoSeguimiento = tipoSeguimiento;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
    
    
}
