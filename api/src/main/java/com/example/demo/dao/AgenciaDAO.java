package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Agencia;

public interface AgenciaDAO extends Repository<Agencia, String>{
	
	List<Agencia>findAll();
	
	Agencia findById(String id);
	
	Agencia save(Agencia p);
	
	void delete(Agencia p);
}
