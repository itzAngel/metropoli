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

import com.example.demo.model.DetalleVentaClienteDestino;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleVentaClienteDestino"})
public class DetalleVentaClienteDestinoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleVentaClienteDestino> listar(){
		return service.listarDetalleVentaClienteDestino();
	}
	@PostMapping
	public DetalleVentaClienteDestino agregar(@RequestBody DetalleVentaClienteDestino p) {
		return service.addDetalleVentaClienteDestino(p);
	}
	
	@GetMapping("/{id}")
	public DetalleVentaClienteDestino listarId(@PathVariable("id")String id){
		return service.listarIdDetalleVentaClienteDestino(id);
	}
	@PutMapping
	public DetalleVentaClienteDestino editar(@RequestBody DetalleVentaClienteDestino p) {
		return service.editDetalleVentaClienteDestino(p);
	}
	@DeleteMapping("/{id}")
	public DetalleVentaClienteDestino delete(@PathVariable("id")String id) {
		return service.deleteDetalleVentaClienteDestino(id);
	}
}
