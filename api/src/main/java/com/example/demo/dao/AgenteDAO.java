package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Agente;

public interface AgenteDAO extends Repository<Agente, String>{
	
	List<Agente>findAll();
	
	Agente findById(String id);
	
	Agente save(Agente p);
	
	void delete(Agente p);
}
