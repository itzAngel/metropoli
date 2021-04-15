package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "pedido")
public class Pedido {
	@Id
    @Column(name = "idpedido", length = 32)
    private String idPedido;
	
	@ManyToOne()
    @JoinColumn(name = "idcliente", nullable = true)
    private Cliente cliente;
	
	@ManyToOne()
    @JoinColumn(name = "idagente", nullable = true)
    private Agente agente;
	
	@ManyToOne()
	@JoinColumn(name = "idmonedaminimo")
	private Moneda idmonedaminimo;
    
	@Column(name = "preciominimo", length = 200)
	private double preciominimo;
	
	@ManyToOne()
	@JoinColumn(name = "idmonedamaximo")
	private Moneda idmonedamaximo;
    
	@Column(name = "preciomaximo", length = 200)
	private double preciomaximo;
	
    @Column(name = "tamanoarea")
	private double tamanoArea;
    
    @Column(name = "anioconstruccion")
	private int anioConstruccion;
    
    @Column(name = "descripcion", length = 500)
	private String descripcion;
    
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "comentario", length = 500)
	private String comentario;
    
    @Column(name = "distribucion", length = 150)
	private String distribucion;
    
    @Column(name = "dormitorios")
	private int dormitorios;
    
    @Column(name = "banios")
	private int banios;
    
    @Column(name = "mantenimientominimo")
	private double mantenimientoMinimo;
    
    @Column(name = "mantenimientomaximo")
	private double mantenimientoMaximo;
    
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
    
    @Column(name = "ascensores")
	private int ascensores;
    
    @Column(name = "cocheras")
	private int cocheras;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<DetallePedidoTipo> listaDetallePedidoTipo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<DetallePedidoUbicacion> listaDetallePedidoUbicacion;
    
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(String idPedido, Cliente cliente, Agente agente, Moneda idmonedaminimo, double preciominimo,
			Moneda idmonedamaximo, double preciomaximo, double tamanoArea, int anioConstruccion, String descripcion,
			Date fecha, String comentario, String distribucion, int dormitorios, int banios, double mantenimientoMinimo,
			double mantenimientoMaximo, int cuartosServicio, int baniosServicio, int pisoPosicion, int cantidadPisos,
			String ambientes, int oficinasPrivadas, int salasReunion, String estadoOficina, int depositos,
			String zonificacion, double linderosFrente, double linderosFondo, int cantidadOficinas, double techoTijeral,
			double patioManiobras, double naveIndustrial, double linderosIzquierda, double linderosDerecha,
			double perimetro, double frontis, int ascensores, int cocheras) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.agente = agente;
		this.idmonedaminimo = idmonedaminimo;
		this.preciominimo = preciominimo;
		this.idmonedamaximo = idmonedamaximo;
		this.preciomaximo = preciomaximo;
		this.tamanoArea = tamanoArea;
		this.anioConstruccion = anioConstruccion;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.comentario = comentario;
		this.distribucion = distribucion;
		this.dormitorios = dormitorios;
		this.banios = banios;
		this.mantenimientoMinimo = mantenimientoMinimo;
		this.mantenimientoMaximo = mantenimientoMaximo;
		this.cuartosServicio = cuartosServicio;
		this.baniosServicio = baniosServicio;
		this.pisoPosicion = pisoPosicion;
		this.cantidadPisos = cantidadPisos;
		this.ambientes = ambientes;
		this.oficinasPrivadas = oficinasPrivadas;
		this.salasReunion = salasReunion;
		this.estadoOficina = estadoOficina;
		this.depositos = depositos;
		this.zonificacion = zonificacion;
		this.linderosFrente = linderosFrente;
		this.linderosFondo = linderosFondo;
		this.cantidadOficinas = cantidadOficinas;
		this.techoTijeral = techoTijeral;
		this.patioManiobras = patioManiobras;
		this.naveIndustrial = naveIndustrial;
		this.linderosIzquierda = linderosIzquierda;
		this.linderosDerecha = linderosDerecha;
		this.perimetro = perimetro;
		this.frontis = frontis;
		this.ascensores = ascensores;
		this.cocheras = cocheras;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public Moneda getIdmonedaminimo() {
		return idmonedaminimo;
	}

	public void setIdmonedaminimo(Moneda idmonedaminimo) {
		this.idmonedaminimo = idmonedaminimo;
	}

	public double getPreciominimo() {
		return preciominimo;
	}

	public void setPreciominimo(double preciominimo) {
		this.preciominimo = preciominimo;
	}

	public Moneda getIdmonedamaximo() {
		return idmonedamaximo;
	}

	public void setIdmonedamaximo(Moneda idmonedamaximo) {
		this.idmonedamaximo = idmonedamaximo;
	}

	public double getPreciomaximo() {
		return preciomaximo;
	}

	public void setPreciomaximo(double preciomaximo) {
		this.preciomaximo = preciomaximo;
	}

	public double getTamanoArea() {
		return tamanoArea;
	}

	public void setTamanoArea(double tamanoArea) {
		this.tamanoArea = tamanoArea;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public double getMantenimientoMinimo() {
		return mantenimientoMinimo;
	}

	public void setMantenimientoMinimo(double mantenimientoMinimo) {
		this.mantenimientoMinimo = mantenimientoMinimo;
	}

	public double getMantenimientoMaximo() {
		return mantenimientoMaximo;
	}

	public void setMantenimientoMaximo(double mantenimientoMaximo) {
		this.mantenimientoMaximo = mantenimientoMaximo;
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

	public int getAscensores() {
		return ascensores;
	}

	public void setAscensores(int ascensores) {
		this.ascensores = ascensores;
	}

	public int getCocheras() {
		return cocheras;
	}

	public void setCocheras(int cocheras) {
		this.cocheras = cocheras;
	}
	
}
