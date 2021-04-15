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

import com.example.demo.model.TabladeTabla;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/tabladeTabla"})
public class TabladeTablaController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<TabladeTabla> listar(){
		return service.listarTabladeTabla();
	}
	@PostMapping
	public TabladeTabla agregar(@RequestBody TabladeTabla p) {
		return service.addTabladeTabla(p);
	}
	
	@GetMapping("/{id}")
	public TabladeTabla listarId(@PathVariable("id")String id){
		return service.listarIdTabladeTabla(id);
	}
	@PutMapping
	public TabladeTabla editar(@RequestBody TabladeTabla p) {
		return service.editTabladeTabla(p);
	}
	@DeleteMapping("/{id}")
	public TabladeTabla delete(@PathVariable("id")String id) {
		return service.deleteTabladeTabla(id);
	}
}
