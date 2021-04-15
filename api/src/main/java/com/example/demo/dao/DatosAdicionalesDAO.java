package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DatosAdicionales;

public interface DatosAdicionalesDAO extends Repository<DatosAdicionales, String>{
	
	List<DatosAdicionales>findAll();
	
	DatosAdicionales findById(String id);
	
	DatosAdicionales save(DatosAdicionales p);
	
	void delete(DatosAdicionales p);
}
