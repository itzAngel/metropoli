package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleVentaAgente;

public interface DetalleVentaAgenteDAO extends Repository<DetalleVentaAgente, String>{
	
	List<DetalleVentaAgente>findAll();
	
	DetalleVentaAgente findById(String id);
	
	DetalleVentaAgente save(DetalleVentaAgente p);
	
	void delete(DetalleVentaAgente p);
}
