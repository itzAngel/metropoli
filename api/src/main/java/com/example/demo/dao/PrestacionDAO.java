package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Prestacion;

public interface PrestacionDAO extends Repository<Prestacion, String>{
	
	List<Prestacion>findAll();
	
	Prestacion findById(String id);
	
	Prestacion save(Prestacion p);
	
	void delete(Prestacion p);
}
