package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {
	@Id
    private String id;
    
	private String name;
    
	private String documentourl;
    
	private String documentoid;
    
	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Documento(String id, String name, String documentourl, String documentoid) {
		super();
		this.id = id;
		this.name = name;
		this.documentourl = documentourl;
		this.documentoid = documentoid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentourl() {
		return documentourl;
	}

	public void setDocumentourl(String documentourl) {
		this.documentourl = documentourl;
	}

	public String getDocumentoid() {
		return documentoid;
	}

	public void setDocumentoid(String documentoid) {
		this.documentoid = documentoid;
	}
	
	
}
