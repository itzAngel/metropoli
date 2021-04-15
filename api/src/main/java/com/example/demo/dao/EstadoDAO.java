package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Estado;

public interface EstadoDAO extends Repository<Estado, String>{
	
	List<Estado>findAll();
	
	Estado findById(String id);
	
	Estado save(Estado p);
	
	void delete(Estado p);
}
