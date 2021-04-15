package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "oportunidad_inversion")
public class OportunidadInversion {
	@Id
    @Column(name = "idoportunidadinversion", length = 32)
    private String idOportunidadInversion;
	
	@ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @Column(name = "telefono", length = 150)
	private String telefono;
    
    @Column(name = "direccion", length = 150)
	private String direccion;
    
    @OneToMany(mappedBy = "foto")
    private List<DetalleFotosOportunidad> listaDetalleFotosOportunidad;
    
	public OportunidadInversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdOportunidadInversion() {
		return idOportunidadInversion;
	}

	public void setIdOportunidadInversion(String idOportunidadInversion) {
		this.idOportunidadInversion = idOportunidadInversion;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    
}
