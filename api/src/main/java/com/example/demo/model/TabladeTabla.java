package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_de_tabla")
public class TabladeTabla {
	@Id
    @Column(name = "idtablatabla", length = 32)
    private String idTablaTabla;
    
    @Column(name = "tipo", length = 150)
	private String tipo;
    
    @Column(name = "codigo", length = 150)
	private String codigo;
    
    @Column(name = "valor", length = 150)
	private String valor;
    
    @Column(name = "descripcion", length = 300)
	private String descripcion;

	public TabladeTabla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabladeTabla(String idTablaTabla, String tipo, String codigo, String valor, String descripcion) {
		super();
		this.idTablaTabla = idTablaTabla;
		this.tipo = tipo;
		this.codigo = codigo;
		this.valor = valor;
		this.descripcion = descripcion;
	}

	public String getIdTablaTabla() {
		return idTablaTabla;
	}

	public void setIdTablaTabla(String idTablaTabla) {
		this.idTablaTabla = idTablaTabla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TabladeTabla [idTablaTabla=" + idTablaTabla + ", tipo=" + tipo + ", codigo=" + codigo + ", valor="
				+ valor + ", descripcion=" + descripcion + "]";
	}
    
}
