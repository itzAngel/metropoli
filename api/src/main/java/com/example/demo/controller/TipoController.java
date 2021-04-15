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

import com.example.demo.model.Tipo;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/tipo"})
public class TipoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Tipo> listar(){
		return service.listarTipo();
	}
	@PostMapping
	public Tipo agregar(@RequestBody Tipo p) {
		return service.addTipo(p);
	}
	
	@GetMapping("/{id}")
	public Tipo listarId(@PathVariable("id")String id){
		return service.listarIdTipo(id);
	}
	@PutMapping
	public Tipo editar(@RequestBody Tipo p) {
		return service.editTipo(p);
	}
	@DeleteMapping("/{id}")
	public Tipo delete(@PathVariable("id")String id) {
		return service.deleteTipo(id);
	}
}
