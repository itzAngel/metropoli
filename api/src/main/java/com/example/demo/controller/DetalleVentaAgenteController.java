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

import com.example.demo.model.DetalleVentaAgente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleVentaAgente"})
public class DetalleVentaAgenteController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleVentaAgente> listar(){
		return service.listarDetalleVentaAgente();
	}
	@PostMapping
	public DetalleVentaAgente agregar(@RequestBody DetalleVentaAgente p) {
		return service.addDetalleVentaAgente(p);
	}
	
	@GetMapping("/{id}")
	public DetalleVentaAgente listarId(@PathVariable("id")String id){
		return service.listarIdDetalleVentaAgente(id);
	}
	@PutMapping
	public DetalleVentaAgente editar(@RequestBody DetalleVentaAgente p) {
		return service.editDetalleVentaAgente(p);
	}
	@DeleteMapping("/{id}")
	public DetalleVentaAgente delete(@PathVariable("id")String id) {
		return service.deleteDetalleVentaAgente(id);
	}
}
