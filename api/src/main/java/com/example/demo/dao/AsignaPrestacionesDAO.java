package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.AsignaPrestaciones;

public interface AsignaPrestacionesDAO extends Repository<AsignaPrestaciones, String>{
	
	List<AsignaPrestaciones>findAll();
	
	AsignaPrestaciones findById(String id);
	
	AsignaPrestaciones save(AsignaPrestaciones p);
	
	void delete(AsignaPrestaciones p);
}
