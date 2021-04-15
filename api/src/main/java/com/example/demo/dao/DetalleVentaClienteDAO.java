package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleVentaCliente;

public interface DetalleVentaClienteDAO extends Repository<DetalleVentaCliente, String>{
	
	List<DetalleVentaCliente>findAll();
	
	DetalleVentaCliente findById(String id);
	
	DetalleVentaCliente save(DetalleVentaCliente p);
	
	void delete(DetalleVentaCliente p);
}
