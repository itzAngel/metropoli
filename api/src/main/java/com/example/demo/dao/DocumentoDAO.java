package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Documento;

public interface DocumentoDAO extends Repository<Documento, String>{
	
	List<Documento>findAll();
	
	Documento findById(String id);
	
	Documento save(Documento p);
	
	void delete(Documento p);
}
