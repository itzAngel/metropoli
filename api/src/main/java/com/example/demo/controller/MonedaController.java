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

import com.example.demo.model.Moneda;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/moneda"})
public class MonedaController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Moneda> listar(){
		return service.listarPrecio();
	}
	@PostMapping
	public Moneda agregar(@RequestBody Moneda p) {
		return service.addPrecio(p);
	}
	
	@GetMapping("/{id}")
	public Moneda listarId(@PathVariable("id")String id){
		return service.listarIdPrecio(id);
	}
	@PutMapping
	public Moneda editar(@RequestBody Moneda p) {
		return service.editPrecio(p);
	}
	@DeleteMapping("/{id}")
	public Moneda delete(@PathVariable("id")String id) {
		return service.deletePrecio(id);
	}
}
