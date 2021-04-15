package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Propiedad;

public interface PropiedadDAO extends Repository<Propiedad, String>{
	
	List<Propiedad>findAll();
	
	Propiedad findById(String id);
	
	Propiedad save(Propiedad p);
	
	void delete(Propiedad p);
}
