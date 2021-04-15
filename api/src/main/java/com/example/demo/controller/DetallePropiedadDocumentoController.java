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

import com.example.demo.model.DetallePropiedadDocumento;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detallePropiedadDocumento"})
public class DetallePropiedadDocumentoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetallePropiedadDocumento> listar(){
		return service.listarDetallePropiedadDocumento();
	}
	@PostMapping
	public DetallePropiedadDocumento agregar(@RequestBody DetallePropiedadDocumento p) {
		return service.addDetallePropiedadDocumento(p);
	}
	
	@GetMapping("/{id}")
	public DetallePropiedadDocumento listarId(@PathVariable("id")String id){
		return service.listarIdDetallePropiedadDocumento(id);
	}
	@PutMapping
	public DetallePropiedadDocumento editar(@RequestBody DetallePropiedadDocumento p) {
		return service.editDetallePropiedadDocumento(p);
	}
	@DeleteMapping("/{id}")
	public DetallePropiedadDocumento delete(@PathVariable("id")String id) {
		return service.deleteDetallePropiedadDocumento(id);
	}
}
