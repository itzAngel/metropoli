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

import com.example.demo.model.DetalleAlquilerClienteDestino;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleAlquilerClienteDestino"})
public class DetalleAlquilerClienteDestinoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleAlquilerClienteDestino> listar(){
		return service.listarDetalleAlquilerClienteDestino();
	}
	@PostMapping
	public DetalleAlquilerClienteDestino agregar(@RequestBody DetalleAlquilerClienteDestino p) {
		return service.addDetalleAlquilerClienteDestino(p);
	}
	
	@GetMapping("/{id}")
	public DetalleAlquilerClienteDestino listarId(@PathVariable("id")String id){
		return service.listarIdDetalleAlquilerClienteDestino(id);
	}
	@PutMapping
	public DetalleAlquilerClienteDestino editar(@RequestBody DetalleAlquilerClienteDestino p) {
		return service.editDetalleAlquilerClienteDestino(p);
	}
	@DeleteMapping("/{id}")
	public DetalleAlquilerClienteDestino delete(@PathVariable("id")String id) {
		return service.deleteDetalleAlquilerClienteDestino(id);
	}
}
