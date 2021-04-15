package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Alquiler;

public interface AlquilerDAO extends Repository<Alquiler, String>{
	
	List<Alquiler>findAll();
	
	Alquiler findById(String id);
	
	Alquiler save(Alquiler p);
	
	void delete(Alquiler p);
}
