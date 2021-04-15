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

import com.example.demo.model.Prestacion;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/prestacion"})
public class PrestacionController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Prestacion> listar(){
		return service.listarPrestacion();
	}
	@PostMapping
	public Prestacion agregar(@RequestBody Prestacion p) {
		return service.addPrestacion(p);
	}
	
	@GetMapping("/{id}")
	public Prestacion listarId(@PathVariable("id")String id){
		return service.listarIdPrestacion(id);
	}
	@PutMapping
	public Prestacion editar(@RequestBody Prestacion p) {
		return service.editPrestacion(p);
	}
	@DeleteMapping("/{id}")
	public Prestacion delete(@PathVariable("id")String id) {
		return service.deletePrestacion(id);
	}
}
