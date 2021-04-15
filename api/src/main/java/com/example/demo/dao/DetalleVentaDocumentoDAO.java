package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleVentaDocumento;

public interface DetalleVentaDocumentoDAO extends Repository<DetalleVentaDocumento, String>{
	
	List<DetalleVentaDocumento>findAll();
	
	DetalleVentaDocumento findById(String id);
	
	DetalleVentaDocumento save(DetalleVentaDocumento p);
	
	void delete(DetalleVentaDocumento p);
}
