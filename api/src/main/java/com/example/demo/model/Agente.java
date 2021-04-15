package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agente")
public class Agente {
	@Id
    @Column(name = "idagente", length = 32)
    private String idAgente;
    
    @Column(name = "correo", length = 200)
	private String correo;
    
    @Column(name = "contrasena", length = 150)
	private String contrasena;
    
    @Column(name = "nombre", length = 200)
	private String nombre;
    
    @Column(name = "apellido", length = 200)
	private String apellido;
    
    @Column(name = "celular", length = 200)
	private String celular;
    
    @Column(name = "urlweb", length = 300)
	private String urlWeb;
    
    @Column(name = "permisosperfil", length = 150)
	private String permisosPerfil;
    
    @Column(name = "idimagen", length = 200)
	private String imagen;
    
    @Column(name = "comentario", length = 500)
	private String comentario;
    
    @Column(name = "habilitado", length = 10)
	private String habilitado;
    
    @OneToMany(mappedBy = "agente")
    private List<Propiedad> listaPropiedad;
    
    @OneToMany(mappedBy = "agente")
    private List<OportunidadInversion> listaOportunidadInversion;
    
    @OneToMany(mappedBy = "agente")
    private List<AsignaAgencia> listaAsignaAgencia;
    
    @OneToMany(mappedBy = "agente")
    private List<Seguimiento> listaSeguimiento;
    
    @OneToMany(mappedBy = "agente")
    private List<DetalleAlquilerAgente> listaDetalleAlquilerAgente;
    
    @OneToMany(mappedBy = "agente")
    private List<DetalleVentaAgente> listaDetalleVentaAgente;
    
    @OneToMany(mappedBy = "agente")
    private List<Pedido> listaPedido;

	public Agente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getUrlWeb() {
		return urlWeb;
	}

	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
	}

	public String getPermisosPerfil() {
		return permisosPerfil;
	}

	public void setPermisosPerfil(String permisosPerfil) {
		this.permisosPerfil = permisosPerfil;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
    
	
}
