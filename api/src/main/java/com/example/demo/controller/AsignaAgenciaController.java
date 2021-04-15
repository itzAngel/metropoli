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

import com.example.demo.model.AsignaAgencia;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/asignaAgencia"})
public class AsignaAgenciaController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<AsignaAgencia> listar(){
		return service.listarAsignaAgencia();
	}
	@PostMapping
	public AsignaAgencia agregar(@RequestBody AsignaAgencia p) {
		return service.addAsignaAgencia(p);
	}
	
	@GetMapping("/{id}")
	public AsignaAgencia listarId(@PathVariable("id")String id){
		return service.listarIdAsignaAgencia(id);
	}
	@PutMapping
	public AsignaAgencia editar(@RequestBody AsignaAgencia p) {
		return service.editAsignaAgencia(p);
	}
	@DeleteMapping("/{id}")
	public AsignaAgencia delete(@PathVariable("id")String id) {
		return service.deleteAsignaAgencia(id);
	}
}
