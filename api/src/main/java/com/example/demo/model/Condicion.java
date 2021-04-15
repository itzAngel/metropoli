package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condicion")
public class Condicion {
	@Id
    @Column(name = "id_condicion", length = 32)
    private String idCondicion;
    
    @Column(name = "condicion", length = 150)
	private String condicion;
    
    @Column(name = "descripcion", length = 200)
	private String descripcion;

	public Condicion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Condicion(String idCondicion, String condicion, String descripcion) {
		super();
		this.idCondicion = idCondicion;
		this.condicion = condicion;
		this.descripcion = descripcion;
	}

	public String getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(String idCondicion) {
		this.idCondicion = idCondicion;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
