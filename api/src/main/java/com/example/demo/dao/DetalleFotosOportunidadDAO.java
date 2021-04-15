package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleFotosOportunidad;

public interface DetalleFotosOportunidadDAO extends Repository<DetalleFotosOportunidad, String>{
	
	List<DetalleFotosOportunidad>findAll();
	
	DetalleFotosOportunidad findById(String id);
	
	DetalleFotosOportunidad save(DetalleFotosOportunidad p);
	
	void delete(DetalleFotosOportunidad p);
}
