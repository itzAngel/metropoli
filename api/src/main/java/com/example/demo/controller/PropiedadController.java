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

import com.example.demo.model.Propiedad;
import com.example.demo.service.MetroService;
@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/propiedad"})
public class PropiedadController {
	@Autowired
	MetroService service;
	
	@GetMapping("/listar")
	public List<Propiedad> listar(){
		return service.listarPropiedad();
	}
	@PostMapping
	public Propiedad agregar(@RequestBody Propiedad p) {
		return service.addPropiedad(p);
	}
	
	@GetMapping("listarid/{id}")
	public Propiedad listarId(@PathVariable("id")String id){
		return service.listarIdPropiedad(id);
	}
	
	@GetMapping("/contar")
	public int contar(){
		return service.contarPropiedad();
	}
	
	@PutMapping
	public Propiedad editar(@RequestBody Propiedad p) {
		return service.editPropiedad(p);
	}
	@DeleteMapping("/{id}")
	public Propiedad delete(@PathVariable("id")String id) {
		return service.deletePropiedad(id);
	}
}
