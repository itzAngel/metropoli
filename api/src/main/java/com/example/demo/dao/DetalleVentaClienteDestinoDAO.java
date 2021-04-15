package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleVentaClienteDestino;

public interface DetalleVentaClienteDestinoDAO extends Repository<DetalleVentaClienteDestino, String>{
	
	List<DetalleVentaClienteDestino>findAll();
	
	DetalleVentaClienteDestino findById(String id);
	
	DetalleVentaClienteDestino save(DetalleVentaClienteDestino p);
	
	void delete(DetalleVentaClienteDestino p);
}
