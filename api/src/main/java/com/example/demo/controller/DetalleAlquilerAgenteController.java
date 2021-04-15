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

import com.example.demo.model.DetalleAlquilerAgente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleAlquilerAgente"})
public class DetalleAlquilerAgenteController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleAlquilerAgente> listar(){
		return service.listarDetalleAlquilerAgente();
	}
	@PostMapping
	public DetalleAlquilerAgente agregar(@RequestBody DetalleAlquilerAgente p) {
		return service.addDetalleAlquilerAgente(p);
	}
	
	@GetMapping("/{id}")
	public DetalleAlquilerAgente listarId(@PathVariable("id")String id){
		return service.listarIdDetalleAlquilerAgente(id);
	}
	@PutMapping
	public DetalleAlquilerAgente editar(@RequestBody DetalleAlquilerAgente p) {
		return service.editDetalleAlquilerAgente(p);
	}
	@DeleteMapping("/{id}")
	public DetalleAlquilerAgente delete(@PathVariable("id")String id) {
		return service.deleteDetalleAlquilerAgente(id);
	}
}
