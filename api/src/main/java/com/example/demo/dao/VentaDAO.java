package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Venta;

public interface VentaDAO extends Repository<Venta, String>{
	
	List<Venta>findAll();
	
	Venta findById(String id);
	
	Venta save(Venta p);
	
	void delete(Venta p);
}
