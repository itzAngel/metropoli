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

import com.example.demo.model.Ubicacion;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/ubicacion"})
public class UbicacionController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Ubicacion> listar(){
		return service.listarUbicacion();
	}
	@PostMapping
	public Ubicacion agregar(@RequestBody Ubicacion p) {
		return service.addUbicacion(p);
	}
	
	@GetMapping("/{id}")
	public Ubicacion listarId(@PathVariable("id")String id){
		return service.listarIdUbicacion(id);
	}
	@PutMapping
	public Ubicacion editar(@RequestBody Ubicacion p) {
		return service.editUbicacion(p);
	}
	@DeleteMapping("/{id}")
	public Ubicacion delete(@PathVariable("id")String id) {
		return service.deleteUbicacion(id);
	}
}
