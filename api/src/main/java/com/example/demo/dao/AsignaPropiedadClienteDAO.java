package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.AsignaPropiedadCliente;

public interface AsignaPropiedadClienteDAO extends Repository<AsignaPropiedadCliente, String>{
	
	List<AsignaPropiedadCliente>findAll();
	
	AsignaPropiedadCliente findById(String id);
	
	AsignaPropiedadCliente save(AsignaPropiedadCliente p);
	
	void delete(AsignaPropiedadCliente p);
}
