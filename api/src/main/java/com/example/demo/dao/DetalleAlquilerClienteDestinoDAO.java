package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleAlquilerClienteDestino;

public interface DetalleAlquilerClienteDestinoDAO extends Repository<DetalleAlquilerClienteDestino, String>{
	
	List<DetalleAlquilerClienteDestino>findAll();
	
	DetalleAlquilerClienteDestino findById(String id);
	
	DetalleAlquilerClienteDestino save(DetalleAlquilerClienteDestino p);
	
	void delete(DetalleAlquilerClienteDestino p);
}
