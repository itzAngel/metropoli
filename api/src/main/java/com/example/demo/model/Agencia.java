package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia {
	@Id
    @Column(name = "idagencia", length = 32)
    private String idAgencia;
    
    @Column(name = "agencia", length = 150)
	private String agencia;
    
    @Column(name = "descripcion", length = 150)
	private String descripcion;

    
	public Agencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agencia(String idAgencia, String agencia, String descripcion) {
		super();
		this.idAgencia = idAgencia;
		this.agencia = agencia;
		this.descripcion = descripcion;
	}


	public String getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
}
