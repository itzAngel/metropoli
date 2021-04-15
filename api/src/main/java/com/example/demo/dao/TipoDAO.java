package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Tipo;

public interface TipoDAO extends Repository<Tipo, String>{
	
	List<Tipo>findAll();
	
	Tipo findById(String id);
	
	Tipo save(Tipo p);
	
	void delete(Tipo p);
}
