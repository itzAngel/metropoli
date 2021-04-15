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

import com.example.demo.model.DetalleAlquilerCliente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleAlquilerCliente"})
public class DetalleAlquilerClienteController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleAlquilerCliente> listar(){
		return service.listarDetalleAlquilerCliente();
	}
	@PostMapping
	public DetalleAlquilerCliente agregar(@RequestBody DetalleAlquilerCliente p) {
		return service.addDetalleAlquilerCliente(p);
	}
	
	@GetMapping("/{id}")
	public DetalleAlquilerCliente listarId(@PathVariable("id")String id){
		return service.listarIdDetalleAlquilerCliente(id);
	}
	@PutMapping
	public DetalleAlquilerCliente editar(@RequestBody DetalleAlquilerCliente p) {
		return service.editDetalleAlquilerCliente(p);
	}
	@DeleteMapping("/{id}")
	public DetalleAlquilerCliente delete(@PathVariable("id")String id) {
		return service.deleteDetalleAlquilerCliente(id);
	}
}
