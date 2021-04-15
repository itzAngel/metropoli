package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetallePedidoTipo;

public interface DetallePedidoTipoDAO extends Repository<DetallePedidoTipo, String>{
	
	List<DetallePedidoTipo>findAll();
	
	DetallePedidoTipo findById(String id);
	
	DetallePedidoTipo save(DetallePedidoTipo p);
	
	void delete(DetallePedidoTipo p);
}
