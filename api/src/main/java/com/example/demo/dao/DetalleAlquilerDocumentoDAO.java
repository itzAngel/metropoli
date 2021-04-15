package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleAlquilerDocumento;

public interface DetalleAlquilerDocumentoDAO extends Repository<DetalleAlquilerDocumento, String>{
	
	List<DetalleAlquilerDocumento>findAll();
	
	DetalleAlquilerDocumento findById(String id);
	
	DetalleAlquilerDocumento save(DetalleAlquilerDocumento p);
	
	void delete(DetalleAlquilerDocumento p);
}
