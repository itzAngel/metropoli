package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Moneda;

public interface MonedaDAO extends Repository<Moneda, String>{
	
	List<Moneda>findAll();
	
	Moneda findById(String id);
	
	Moneda save(Moneda p);
	
	void delete(Moneda p);
}
