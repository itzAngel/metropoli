package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Cliente;

public interface ClienteDAO extends Repository<Cliente, String>{
	
	List<Cliente>findAll();
	
	Cliente findById(String id);
	
	Cliente save(Cliente p);
	
	void delete(Cliente p);
}
