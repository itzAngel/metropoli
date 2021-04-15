package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.OportunidadInversion;

public interface OportunidadInversionDAO extends Repository<OportunidadInversion, String>{
	
	List<OportunidadInversion>findAll();
	
	OportunidadInversion findById(String id);
	
	OportunidadInversion save(OportunidadInversion p);
	
	void delete(OportunidadInversion p);
}
