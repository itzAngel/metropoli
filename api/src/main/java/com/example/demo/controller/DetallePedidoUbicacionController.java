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

import com.example.demo.model.DetallePedidoUbicacion;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detallePedidoUbicacion"})
public class DetallePedidoUbicacionController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetallePedidoUbicacion> listar(){
		return service.listarDetallePedidoUbicacion();
	}
	@PostMapping
	public DetallePedidoUbicacion agregar(@RequestBody DetallePedidoUbicacion p) {
		return service.addDetallePedidoUbicacion(p);
	}
	
	@GetMapping("/{id}")
	public DetallePedidoUbicacion listarId(@PathVariable("id")String id){
		return service.listarIdDetallePedidoUbicacion(id);
	}
	@PutMapping
	public DetallePedidoUbicacion editar(@RequestBody DetallePedidoUbicacion p) {
		return service.editDetallePedidoUbicacion(p);
	}
	@DeleteMapping("/{id}")
	public DetallePedidoUbicacion delete(@PathVariable("id")String id) {
		return service.deleteDetallePedidoUbicacion(id);
	}
}
