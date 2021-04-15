package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Pedido;

public interface PedidoDAO extends Repository<Pedido, String>{
	
	List<Pedido>findAll();
	
	Pedido findById(String id);
	
	Pedido save(Pedido p);
	
	void delete(Pedido p);
}
