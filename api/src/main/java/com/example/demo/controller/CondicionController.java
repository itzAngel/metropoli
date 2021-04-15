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

import com.example.demo.model.Condicion;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/condicion"})
public class CondicionController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Condicion> listar(){
		return service.listarCondicion();
	}
	@PostMapping
	public Condicion agregar(@RequestBody Condicion p) {
		return service.addCondicion(p);
	}
	
	@GetMapping("/{id}")
	public Condicion listarId(@PathVariable("id")String id){
		return service.listarIdCondicion(id);
	}
	@PutMapping
	public Condicion editar(@RequestBody Condicion p) {
		return service.editCondicion(p);
	}
	@DeleteMapping("/{id}")
	public Condicion delete(@PathVariable("id")String id) {
		return service.deleteCondicion(id);
	}
}
