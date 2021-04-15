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

import com.example.demo.model.Contacto;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/contacto"})
public class ContactoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Contacto> listar(){
		return service.listarContacto();
	}
	@PostMapping
	public Contacto agregar(@RequestBody Contacto p) {
		return service.addContacto(p);
	}
	
	@GetMapping("/{id}")
	public Contacto listarId(@PathVariable("id")String id){
		return service.listarIdContacto(id);
	}
	@PutMapping
	public Contacto editar(@RequestBody Contacto p) {
		return service.editContacto(p);
	}
	@DeleteMapping("/{id}")
	public Contacto delete(@PathVariable("id")String id) {
		return service.deleteContacto(id);
	}
}
