package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetallePropiedadDocumento;

public interface DetallePropiedadDocumentoDAO extends Repository<DetallePropiedadDocumento, String>{
	
	List<DetallePropiedadDocumento>findAll();
	
	DetallePropiedadDocumento findById(String id);
	
	DetallePropiedadDocumento save(DetallePropiedadDocumento p);
	
	void delete(DetallePropiedadDocumento p);
}
