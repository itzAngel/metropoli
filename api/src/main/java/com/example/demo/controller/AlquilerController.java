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

import com.example.demo.model.Alquiler;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/alquiler"})
public class AlquilerController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Alquiler> listar(){
		return service.listarAlquiler();
	}
	@PostMapping
	public Alquiler agregar(@RequestBody Alquiler p) {
		return service.addAlquiler(p);
	}
	
	@GetMapping("/{id}")
	public Alquiler listarId(@PathVariable("id")String id){
		return service.listarIdAlquiler(id);
	}
	@PutMapping
	public Alquiler editar(@RequestBody Alquiler p) {
		return service.editAlquiler(p);
	}
	@DeleteMapping("/{id}")
	public Alquiler delete(@PathVariable("id")String id) {
		return service.deleteAlquiler(id);
	}
}
