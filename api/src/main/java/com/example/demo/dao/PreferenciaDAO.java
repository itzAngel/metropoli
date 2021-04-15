package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Preferencia;

public interface PreferenciaDAO extends Repository<Preferencia, String>{
	
	List<Preferencia>findAll();
	
	Preferencia findById(String id);
	
	Preferencia save(Preferencia p);
	
	void delete(Preferencia p);
}
