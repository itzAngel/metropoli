package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.TabladeTabla;

public interface TabladeTablaDAO extends Repository<TabladeTabla, String>{
	
	List<TabladeTabla>findAll();
	
	TabladeTabla findById(String id);
	
	TabladeTabla save(TabladeTabla p);
	
	void delete(TabladeTabla p);
}
