package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {
	@Id
    @Column(name = "id_tipo", length = 32)
    private String idTipo;
    
    @Column(name = "tipo", length = 150)
	private String tipo;
    
    @Column(name = "descripcion", length = 200)
	private String descripcion;

	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo(String idTipo, String tipo, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
