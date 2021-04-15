package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/pedido"})
public class PedidoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Pedido> listar(){
		return service.listarPedido();
	}
	@PostMapping
	public Pedido agregar(@RequestBody Pedido p) {
		return service.addPedido(p);
	}
	
	@GetMapping("/{id}")
	public Pedido listarId(@PathVariable("id")String id){
		return service.listarIdPedido(id);
	}
	@PutMapping
	public Pedido editar(@RequestBody Pedido p) {
		return service.editPedido(p);
	}
	@DeleteMapping("/{id}")
	public Pedido delete(@PathVariable("id")String id) {
		return service.deletePedido(id);
	}
}
