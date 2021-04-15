package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.AsignaAgencia;

public interface AsignaAgenciaDAO extends Repository<AsignaAgencia, String>{
	
	List<AsignaAgencia>findAll();
	
	AsignaAgencia findById(String id);
	
	AsignaAgencia save(AsignaAgencia p);
	
	void delete(AsignaAgencia p);
}
