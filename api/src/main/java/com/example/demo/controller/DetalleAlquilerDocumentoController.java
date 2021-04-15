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

import com.example.demo.model.DetalleAlquilerDocumento;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleAlquilerDocumento"})
public class DetalleAlquilerDocumentoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleAlquilerDocumento> listar(){
		return service.listarDetalleAlquilerDocumento();
	}
	@PostMapping
	public DetalleAlquilerDocumento agregar(@RequestBody DetalleAlquilerDocumento p) {
		return service.addDetalleAlquilerDocumento(p);
	}
	
	@GetMapping("/{id}")
	public DetalleAlquilerDocumento listarId(@PathVariable("id")String id){
		return service.listarIdDetalleAlquilerDocumento(id);
	}
	@PutMapping
	public DetalleAlquilerDocumento editar(@RequestBody DetalleAlquilerDocumento p) {
		return service.editDetalleAlquilerDocumento(p);
	}
	@DeleteMapping("/{id}")
	public DetalleAlquilerDocumento delete(@PathVariable("id")String id) {
		return service.deleteDetalleAlquilerDocumento(id);
	}
}
