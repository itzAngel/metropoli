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

import com.example.demo.model.Estado;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/estado"})
public class EstadoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Estado> listar(){
		return service.listarEstado();
	}
	@PostMapping
	public Estado agregar(@RequestBody Estado p) {
		return service.addEstado(p);
	}
	
	@GetMapping("/{id}")
	public Estado listarId(@PathVariable("id")String id){
		return service.listarIdEstado(id);
	}
	@PutMapping
	public Estado editar(@RequestBody Estado p) {
		return service.editEstado(p);
	}
	@DeleteMapping("/{id}")
	public Estado delete(@PathVariable("id")String id) {
		return service.deleteEstado(id);
	}
}
