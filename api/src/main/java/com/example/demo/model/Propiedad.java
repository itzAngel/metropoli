package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "propiedad")
public class Propiedad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "idpropiedad", length = 32)
    private String idPropiedad;
    
    @Column(name = "titulo", length = 200)
	private String titulo;
    
    @ManyToOne()
    @JoinColumn(name = "idtipo", nullable = true)
	private Tipo tipo;
    
    @ManyToOne()
    @JoinColumn(name = "idcondicion", nullable = true)
	private Condicion condicion;
    
    @ManyToOne()
    @JoinColumn(name = "idestado", nullable = true)
	private Estado estado;
    
    @ManyToOne()
    @JoinColumn(name = "idubicacion", nullable = true)
	private Ubicacion ubicacion;
    
    @ManyToOne()
	@JoinColumn(name = "idmoneda", nullable = true)
	private Moneda moneda;
    
    @Column(name = "precio", length = 200)
	private double precio;
    
    @Column(name = "tamanoarea")
	private double tamanoArea;
    
    @Column(name = "direccion", length = 200)
	private String direccion;
    
    @Column(name = "anioconstruccion")
	private int anioConstruccion;
    
    @Column(name = "descripcion", length = 500)
	private String descripcion;
    
    @Column(name = "idfotosuperior", length = 200)
	private String foto;
    
    @Column(name = "idvideo", length = 200)
	private String video;
    
    @Column(name = "idtour", length = 200)
	private String tour;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaingreso")
    private Date fechaIngreso;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;
    
    @Column(name = "comentario", length = 500)
	private String comentario;
    
    @Column(name = "distribucion", length = 150)
	private String distribucion;
    
    @Column(name = "dormitorios")
	private int dormitorios;
    
    @Column(name = "banios")
	private int banios;
    
    @Column(name = "cocheras")
	private int cocheras;
    
    @ManyToOne()
    @JoinColumn(name = "idmonedamantenimiento", nullable = true)
	private Moneda monedamantenimiento;
    
    @Column(name = "mantenimiento", length = 200)
	private double mantenimiento;
    
    @Column(name = "cuartosservicio")
	private int cuartosServicio;
    
    @Column(name = "baniosservicio")
	private int baniosServicio;
    
    @Column(name = "pisoposicion")
	private int pisoPosicion;
    
    @Column(name = "cantidadpisos")
	private int cantidadPisos;
    
    @Column(name = "ambientes", length = 200)
	private String ambientes;
    
    @Column(name = "oficinasprivadas")
	private int oficinasPrivadas;
    
    @Column(name = "salasreunion")
	private int salasReunion;
    
    @Column(name = "estadooficina", length = 150)
	private String estadoOficina;
    
    @Column(name = "depositos")
	private int depositos;
    
    @Column(name = "zonificacion", length = 150)
	private String zonificacion;
    
    @Column(name = "linderosfrente")
	private double linderosFrente;
    
    @Column(name = "linderosfondo")
	private double linderosFondo;
    
    @Column(name = "cantidadoficinas")
	private int cantidadOficinas;
    
    @Column(name = "techotijeral")
	private double techoTijeral;
    
    @Column(name = "patiomaniobras")
	private double patioManiobras;
    
    @Column(name = "naveindustrial")
	private double naveIndustrial;
    
    @Column(name = "linderosizquierda")
	private double linderosIzquierda;
    
    @Column(name = "linderosderecha")
	private double linderosDerecha;
    
    @Column(name = "perimetro")
	private double perimetro;
    
    @Column(name = "frontis")
	private double frontis;
    
    @Column(name = "areaconstruida")
	private double areaConstruida;
    
    @Column(name = "areaocupada")
	private double areaOcupada;
    
    @Column(name = "areaaires")
	private double areaAires;
    
    @Column(name = "ascensores")
	private int ascensores;
    
    @ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
    
    @ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "propiedad")
    private List<DatosAdicionales> listaDatosAdicionales = new ArrayList<>();
    
    @OneToMany(mappedBy = "propiedad")
    private List<AsignaPrestaciones> listaAsignaPrestaciones = new ArrayList<>();
    
    @OneToMany(mappedBy = "propiedad")
    private List<DetalleFotosPropiedad> listaDetalleFotosPropiedad = new ArrayList<>();
    
    @OneToMany(mappedBy = "propiedad")
    private List<DetallePropiedadDocumento> listaDetallePropiedadDocumentos = new ArrayList<>();
    
    @OneToMany(mappedBy = "propiedad")
    private List<AsignaPropiedadCliente> listaAsignaPropiedadCliente = new ArrayList<>();
    
    @OneToMany(mappedBy = "propiedad")
    private List<Venta> listaVenta = new ArrayList<>();
    
	public Propiedad() {
		super();
	}

	public String getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(String idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTamanoArea() {
		return tamanoArea;
	}

	public void setTamanoArea(double tamanoArea) {
		this.tamanoArea = tamanoArea;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getAnioConstruccion() {
		return anioConstruccion;
	}

	public void setAnioConstruccion(int anioConstruccion) {
		this.anioConstruccion = anioConstruccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
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

	public String getDistribucion() {
		return distribucion;
	}

	public void setDistribucion(String distribucion) {
		this.distribucion = distribucion;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public int getBanios() {
		return banios;
	}

	public void setBanios(int banios) {
		this.banios = banios;
	}

	public int getCocheras() {
		return cocheras;
	}

	public void setCocheras(int cocheras) {
		this.cocheras = cocheras;
	}

	public Moneda getMonedamantenimiento() {
		return monedamantenimiento;
	}

	public void setMonedamantenimiento(Moneda monedamantenimiento) {
		this.monedamantenimiento = monedamantenimiento;
	}

	public double getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(double mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public int getCuartosServicio() {
		return cuartosServicio;
	}

	public void setCuartosServicio(int cuartosServicio) {
		this.cuartosServicio = cuartosServicio;
	}

	public int getBaniosServicio() {
		return baniosServicio;
	}

	public void setBaniosServicio(int baniosServicio) {
		this.baniosServicio = baniosServicio;
	}

	public int getPisoPosicion() {
		return pisoPosicion;
	}

	public void setPisoPosicion(int pisoPosicion) {
		this.pisoPosicion = pisoPosicion;
	}

	public int getCantidadPisos() {
		return cantidadPisos;
	}

	public void setCantidadPisos(int cantidadPisos) {
		this.cantidadPisos = cantidadPisos;
	}

	public String getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(String ambientes) {
		this.ambientes = ambientes;
	}

	public int getOficinasPrivadas() {
		return oficinasPrivadas;
	}

	public void setOficinasPrivadas(int oficinasPrivadas) {
		this.oficinasPrivadas = oficinasPrivadas;
	}

	public int getSalasReunion() {
		return salasReunion;
	}

	public void setSalasReunion(int salasReunion) {
		this.salasReunion = salasReunion;
	}

	public String getEstadoOficina() {
		return estadoOficina;
	}

	public void setEstadoOficina(String estadoOficina) {
		this.estadoOficina = estadoOficina;
	}

	public int getDepositos() {
		return depositos;
	}

	public void setDepositos(int depositos) {
		this.depositos = depositos;
	}

	public String getZonificacion() {
		return zonificacion;
	}

	public void setZonificacion(String zonificacion) {
		this.zonificacion = zonificacion;
	}

	public double getLinderosFrente() {
		return linderosFrente;
	}

	public void setLinderosFrente(double linderosFrente) {
		this.linderosFrente = linderosFrente;
	}

	public double getLinderosFondo() {
		return linderosFondo;
	}

	public void setLinderosFondo(double linderosFondo) {
		this.linderosFondo = linderosFondo;
	}

	public int getCantidadOficinas() {
		return cantidadOficinas;
	}

	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}

	public double getTechoTijeral() {
		return techoTijeral;
	}

	public void setTechoTijeral(double techoTijeral) {
		this.techoTijeral = techoTijeral;
	}

	public double getPatioManiobras() {
		return patioManiobras;
	}

	public void setPatioManiobras(double patioManiobras) {
		this.patioManiobras = patioManiobras;
	}

	public double getNaveIndustrial() {
		return naveIndustrial;
	}

	public void setNaveIndustrial(double naveIndustrial) {
		this.naveIndustrial = naveIndustrial;
	}

	public double getLinderosIzquierda() {
		return linderosIzquierda;
	}

	public void setLinderosIzquierda(double linderosIzquierda) {
		this.linderosIzquierda = linderosIzquierda;
	}

	public double getLinderosDerecha() {
		return linderosDerecha;
	}

	public void setLinderosDerecha(double linderosDerecha) {
		this.linderosDerecha = linderosDerecha;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getFrontis() {
		return frontis;
	}

	public void setFrontis(double frontis) {
		this.frontis = frontis;
	}

	public double getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(double areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public double getAreaOcupada() {
		return areaOcupada;
	}

	public void setAreaOcupada(double areaOcupada) {
		this.areaOcupada = areaOcupada;
	}

	public double getAreaAires() {
		return areaAires;
	}

	public void setAreaAires(double areaAires) {
		this.areaAires = areaAires;
	}

	public int getAscensores() {
		return ascensores;
	}

	public void setAscensores(int ascensores) {
		this.ascensores = ascensores;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
