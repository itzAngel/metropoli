package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {
	@Id
    @Column(name = "id_ubicacion", length = 32)
    private String idUbicacion;
    
    @Column(name = "ubicacion", length = 150)
	private String ubicacion;
    
    @Column(name = "descripcion", length = 200)
	private String descripcion;

	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ubicacion(String idUbicacion, String ubicacion, String descripcion) {
		super();
		this.idUbicacion = idUbicacion;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
	}

	public String getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
