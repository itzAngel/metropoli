package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "multimedia")
public class Multimedia {
	@Id
    private String id;
    
	private String name;
    
	private String multimediaurl;
    
	private String multimediaid;

	public Multimedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Multimedia(String id, String name, String multimediaurl, String multimediaid) {
		super();
		this.id = id;
		this.name = name;
		this.multimediaurl = multimediaurl;
		this.multimediaid = multimediaid;
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

	public String getMultimediaurl() {
		return multimediaurl;
	}

	public void setMultimediaurl(String multimediaurl) {
		this.multimediaurl = multimediaurl;
	}

	public String getMultimediaid() {
		return multimediaid;
	}

	public void setMultimediaid(String multimediaid) {
		this.multimediaid = multimediaid;
	}
	
    
    
}
