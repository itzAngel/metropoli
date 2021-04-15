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

import com.example.demo.model.Preferencia;
import com.example.demo.model.TabladeTabla;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/preferencia"})
public class PreferenciaController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<Preferencia> listar(){
		return service.listarPreferencia();
	}
	@PostMapping
	public Preferencia agregar(@RequestBody Preferencia p) {
		return service.addPreferencia(p);
	}
	
	@GetMapping("/{id}")
	public Preferencia listarId(@PathVariable("id")String id){
		return service.listarIdPreferencia(id);
	}
	@PutMapping
	public Preferencia editar(@RequestBody Preferencia p) {
		return service.editPreferencia(p);
	}
	@DeleteMapping("/{id}")
	public Preferencia delete(@PathVariable("id")String id) {
		return service.deletePreferencia(id);
	}
}
