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

import com.example.demo.model.DatosAdicionales;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/datosAdicionales"})
public class DatosAdicionalesController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DatosAdicionales> listar(){
		return service.listarDatosAdicionales();
	}
	@PostMapping
	public DatosAdicionales agregar(@RequestBody DatosAdicionales p) {
		return service.addDatosAdicionales(p);
	}
	
	@GetMapping("/{id}")
	public DatosAdicionales listarId(@PathVariable("id")String id){
		return service.listarIdDatosAdicionales(id);
	}
	@PutMapping
	public DatosAdicionales editar(@RequestBody DatosAdicionales p) {
		return service.editDatosAdicionales(p);
	}
	@DeleteMapping("/{id}")
	public DatosAdicionales delete(@PathVariable("id")String id) {
		return service.deleteDatosAdicionales(id);
	}
}
