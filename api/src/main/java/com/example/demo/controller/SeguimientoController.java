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

import com.example.demo.model.Seguimiento;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/seguimiento"})
public class SeguimientoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Seguimiento> listar(){
		return service.listarSeguimiento();
	}
	@PostMapping
	public Seguimiento agregar(@RequestBody Seguimiento p) {
		return service.addSeguimiento(p);
	}
	
	@GetMapping("/{id}")
	public Seguimiento listarId(@PathVariable("id")String id){
		return service.listarIdSeguimiento(id);
	}
	@PutMapping
	public Seguimiento editar(@RequestBody Seguimiento p) {
		return service.editSeguimiento(p);
	}
	@DeleteMapping("/{id}")
	public Seguimiento delete(@PathVariable("id")String id) {
		return service.deleteSeguimiento(id);
	}
}
