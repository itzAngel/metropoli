package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Condicion;

public interface CondicionDAO extends Repository<Condicion, String>{
	
	List<Condicion>findAll();
	
	Condicion findById(String id);
	
	Condicion save(Condicion p);
	
	void delete(Condicion p);
}
