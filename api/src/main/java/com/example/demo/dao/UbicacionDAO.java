package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Ubicacion;

public interface UbicacionDAO extends Repository<Ubicacion, String>{
	
	List<Ubicacion>findAll();
	
	Ubicacion findById(String id);
	
	Ubicacion save(Ubicacion p);
	
	void delete(Ubicacion p);
}
