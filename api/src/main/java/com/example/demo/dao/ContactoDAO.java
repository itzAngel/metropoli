package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Agencia;
import com.example.demo.model.Contacto;

public interface ContactoDAO extends Repository<Contacto, String>{
	
	List<Contacto>findAll();
	
	Contacto findById(String id);
	
	Contacto save(Contacto p);
	
	void delete(Contacto p);
}
