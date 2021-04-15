package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto {
	@Id
    @Column(name = "idcontacto", length = 32)
    private String idContacto;
    
    @Column(name = "nombre", length = 150)
	private String nombre;
    
    @Column(name = "correo", length = 150)
	private String correo;
    
    @Column(name = "celular", length = 150)
	private String celular;
    
    @Column(name = "mensaje", length = 200)
	private String mensaje;

    @Column(name = "habilitado", length = 10)
	private String habilitado;
    
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIdContacto() {
		return idContacto;
	}


	public void setIdContacto(String idContacto) {
		this.idContacto = idContacto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
	
}
