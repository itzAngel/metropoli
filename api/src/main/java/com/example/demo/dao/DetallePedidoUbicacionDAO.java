package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetallePedidoUbicacion;

public interface DetallePedidoUbicacionDAO extends Repository<DetallePedidoUbicacion, String>{
	
	List<DetallePedidoUbicacion>findAll();
	
	DetallePedidoUbicacion findById(String id);
	
	DetallePedidoUbicacion save(DetallePedidoUbicacion p);
	
	void delete(DetallePedidoUbicacion p);
}
