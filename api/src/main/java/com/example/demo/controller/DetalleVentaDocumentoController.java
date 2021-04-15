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

import com.example.demo.model.DetalleVentaDocumento;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleVentaDocumento"})
public class DetalleVentaDocumentoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleVentaDocumento> listar(){
		return service.listarDetalleVentaDocumento();
	}
	@PostMapping
	public DetalleVentaDocumento agregar(@RequestBody DetalleVentaDocumento p) {
		return service.addDetalleVentaDocumento(p);
	}
	
	@GetMapping("/{id}")
	public DetalleVentaDocumento listarId(@PathVariable("id")String id){
		return service.listarIdDetalleVentaDocumento(id);
	}
	@PutMapping
	public DetalleVentaDocumento editar(@RequestBody DetalleVentaDocumento p) {
		return service.editDetalleVentaDocumento(p);
	}
	@DeleteMapping("/{id}")
	public DetalleVentaDocumento delete(@PathVariable("id")String id) {
		return service.deleteDetalleVentaDocumento(id);
	}
}
