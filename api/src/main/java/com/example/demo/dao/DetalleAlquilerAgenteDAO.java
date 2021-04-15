package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleAlquilerAgente;

public interface DetalleAlquilerAgenteDAO extends Repository<DetalleAlquilerAgente, String>{
	
	List<DetalleAlquilerAgente>findAll();
	
	DetalleAlquilerAgente findById(String id);
	
	DetalleAlquilerAgente save(DetalleAlquilerAgente p);
	
	void delete(DetalleAlquilerAgente p);
}
