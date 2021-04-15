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

import com.example.demo.model.AsignaPropiedadCliente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/asignaPropiedadCliente"})
public class AsignaPropiedadClienteController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<AsignaPropiedadCliente> listar(){
		return service.listarAsignaPropiedadCliente();
	}
	@PostMapping
	public AsignaPropiedadCliente agregar(@RequestBody AsignaPropiedadCliente p) {
		return service.addAsignaPropiedadCliente(p);
	}
	
	@GetMapping("/{id}")
	public AsignaPropiedadCliente listarId(@PathVariable("id")String id){
		return service.listarIdAsignaPropiedadCliente(id);
	}
	@PutMapping
	public AsignaPropiedadCliente editar(@RequestBody AsignaPropiedadCliente p) {
		return service.editAsignaPropiedadCliente(p);
	}
	@DeleteMapping("/{id}")
	public AsignaPropiedadCliente delete(@PathVariable("id")String id) {
		return service.deleteAsignaPropiedadCliente(id);
	}
}
