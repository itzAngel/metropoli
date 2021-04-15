package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.example.demo.model.Agente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/agente"})
public class AgenteController {
	@Autowired
	MetroService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping
	public List<Agente> listar(){
		return service.listarAgente();
	}
	@PostMapping
	public Agente agregar(@RequestBody Agente p) {
		String contra = encoder.encode(p.getContrasena());
		p.setContrasena(contra);
		return service.addAgente(p);
	}
	
	@GetMapping("/{id}")
	public Agente listarId(@PathVariable("id")String id){
		return service.listarIdAgente(id);
	}
	@PutMapping
	public Agente editar(@RequestBody Agente p) {
		return service.editAgente(p);
	}
	@DeleteMapping("/{id}")
	public Agente delete(@PathVariable("id")String id) {
		return service.deleteAgente(id);
	}
}
