package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleAlquilerCliente;

public interface DetalleAlquilerClienteDAO extends Repository<DetalleAlquilerCliente, String>{
	
	List<DetalleAlquilerCliente>findAll();
	
	DetalleAlquilerCliente findById(String id);
	
	DetalleAlquilerCliente save(DetalleAlquilerCliente p);
	
	void delete(DetalleAlquilerCliente p);
}
