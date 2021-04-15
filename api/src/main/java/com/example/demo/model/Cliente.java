package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
    @Column(name = "idcliente", length = 32)
    private String idCliente;
    
    @Column(name = "nombre", length = 200)
	private String nombre;
    
    @Column(name = "apellido", length = 150)
	private String apellido;
    
    @Column(name = "estadocliente", length = 150)
	private String estadoCliente;
    
    @Column(name = "idfoto", length = 200)
    private String foto;
    
    @Column(name = "telefono", length = 150)
	private String telefono;
    
    @Column(name = "correo", length = 200)
	private String correo;
    
    @Column(name = "dni", length = 100)
	private String dni;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaingreso")
    private Date fechaIngreso;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;
    
    @Column(name = "comentario", length = 500)
	private String comentario;
    
    @ManyToOne()
    @JoinColumn(name = "idpreferencia", nullable = true)
    private Preferencia preferencia;
    
    @ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @Column(name = "modocaptacion", length = 150)
	private String modoCaptacion;
    
    @Column(name = "empresa", length = 150)
	private String empresa;
    
    @Column(name = "habilitado", length = 10)
	private String habilitado;
    
    @OneToMany(mappedBy = "cliente")
    private List<AsignaPropiedadCliente> listaAsignaPropiedadCliente;
    
    @OneToMany(mappedBy = "cliente")
    private List<Seguimiento> listaSeguimiento;
    
    @OneToMany( mappedBy = "cliente")
    private List<Pedido> listaPedido;
    
    @OneToMany( mappedBy = "cliente")
    private List<DetalleVentaCliente> listaDetalleVentaCliente;
    
    @OneToMany( mappedBy = "cliente")
    private List<DetalleVentaClienteDestino> listaDetalleVentaClienteDestino;
    
    @OneToMany( mappedBy = "cliente")
    private List<DetalleAlquilerCliente> listaDetalleAlquilerCliente;
    
    @OneToMany( mappedBy = "cliente")
    private List<DetalleAlquilerClienteDestino> listaDetalleAlquilerClienteDestino;
    
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
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

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public String getModoCaptacion() {
		return modoCaptacion;
	}

	public void setModoCaptacion(String modoCaptacion) {
		this.modoCaptacion = modoCaptacion;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
    
	
}
