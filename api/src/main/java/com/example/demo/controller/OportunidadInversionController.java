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

import com.example.demo.model.OportunidadInversion;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/oportunidadInversion"})
public class OportunidadInversionController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<OportunidadInversion> listar(){
		return service.listarOportunidadInversion();
	}
	@PostMapping
	public OportunidadInversion agregar(@RequestBody OportunidadInversion p) {
		return service.addOportunidadInversion(p);
	}
	
	@GetMapping("/{id}")
	public OportunidadInversion listarId(@PathVariable("id")String id){
		return service.listarIdOportunidadInversion(id);
	}
	@PutMapping
	public OportunidadInversion editar(@RequestBody OportunidadInversion p) {
		return service.editOportunidadInversion(p);
	}
	@DeleteMapping("/{id}")
	public OportunidadInversion delete(@PathVariable("id")String id) {
		return service.deleteOportunidadInversion(id);
	}
}
