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

import com.example.demo.model.Agencia;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/agencia"})
public class AgenciaController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Agencia> listar(){
		return service.listarAgencia();
	}
	@PostMapping
	public Agencia agregar(@RequestBody Agencia p) {
		return service.addAgencia(p);
	}
	
	@GetMapping("/{id}")
	public Agencia listarId(@PathVariable("id")String id){
		return service.listarIdAgencia(id);
	}
	@PutMapping
	public Agencia editar(@RequestBody Agencia p) {
		return service.editAgencia(p);
	}
	@DeleteMapping("/{id}")
	public Agencia delete(@PathVariable("id")String id) {
		return service.deleteAgencia(id);
	}
}
