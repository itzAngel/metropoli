package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moneda")
public class Moneda {
	@Id
    @Column(name = "idmoneda", length = 32)
    private String idMoneda;
    
    @Column(name = "moneda", length = 100)
	private String moneda;
    
    @Column(name = "simbolo", length = 10)
	private String simbolo;
    
	public Moneda() {
		super();
	}

	public Moneda(String idMoneda, String moneda) {
		super();
		this.idMoneda = idMoneda;
		this.moneda = moneda;
	}

	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
