package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Imagen {
    @Id
    private String id;
    private String name;
    private String imagenurl;
    private String imagenid;

    public Imagen() {
    }

	public Imagen(String id,String name, String imagenurl, String imagenid) {
		super();
		this.id = id;
		this.name = name;
		this.imagenurl = imagenurl;
		this.imagenid = imagenid;
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

	public String getImagenurl() {
		return imagenurl;
	}

	public void setImagenurl(String imagenurl) {
		this.imagenurl = imagenurl;
	}

	public String getImagenid() {
		return imagenid;
	}

	public void setImagenid(String imagenid) {
		this.imagenid = imagenid;
	}
    
}