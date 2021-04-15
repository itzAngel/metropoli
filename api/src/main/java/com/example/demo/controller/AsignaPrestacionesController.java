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

import com.example.demo.model.AsignaPrestaciones;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/asignaPrestaciones"})
public class AsignaPrestacionesController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<AsignaPrestaciones> listar(){
		return service.listarAsignaPrestaciones();
	}
	@PostMapping
	public AsignaPrestaciones agregar(@RequestBody AsignaPrestaciones p) {
		return service.addAsignaPrestaciones(p);
	}
	
	@GetMapping("/{id}")
	public AsignaPrestaciones listarId(@PathVariable("id")String id){
		return service.listarIdAsignaPrestaciones(id);
	}
	@PutMapping
	public AsignaPrestaciones editar(@RequestBody AsignaPrestaciones p) {
		return service.editAsignaPrestaciones(p);
	}
	@DeleteMapping("/{id}")
	public AsignaPrestaciones delete(@PathVariable("id")String id) {
		return service.deleteAsignaPrestaciones(id);
	}
}
