package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	@Id
    @Column(name = "id_estado", length = 32)
    private String idEstado;
    
    @Column(name = "estado", length = 150)
	private String estado;
    
    @Column(name = "descripcion", length = 200)
	private String descripcion;

	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estado(String idEstado, String estado, String descripcion) {
		super();
		this.idEstado = idEstado;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
