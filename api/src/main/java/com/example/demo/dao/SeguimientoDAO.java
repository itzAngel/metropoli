package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Seguimiento;

public interface SeguimientoDAO extends Repository<Seguimiento, String>{
	
	List<Seguimiento>findAll();
	
	Seguimiento findById(String id);
	
	Seguimiento save(Seguimiento p);
	
	void delete(Seguimiento p);
}
