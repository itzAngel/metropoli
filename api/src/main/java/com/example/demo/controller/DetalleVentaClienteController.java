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

import com.example.demo.model.DetalleVentaCliente;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleVentaCliente"})
public class DetalleVentaClienteController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleVentaCliente> listar(){
		return service.listarDetalleVentaCliente();
	}
	@PostMapping
	public DetalleVentaCliente agregar(@RequestBody DetalleVentaCliente p) {
		return service.addDetalleVentaCliente(p);
	}
	
	@GetMapping("/{id}")
	public DetalleVentaCliente listarId(@PathVariable("id")String id){
		return service.listarIdDetalleVentaCliente(id);
	}
	@PutMapping
	public DetalleVentaCliente editar(@RequestBody DetalleVentaCliente p) {
		return service.editDetalleVentaCliente(p);
	}
	@DeleteMapping("/{id}")
	public DetalleVentaCliente delete(@PathVariable("id")String id) {
		return service.deleteDetalleVentaCliente(id);
	}
}
