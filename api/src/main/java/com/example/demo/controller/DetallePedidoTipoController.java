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

import com.example.demo.model.DetallePedidoTipo;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detallePedidoTipo"})
public class DetallePedidoTipoController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetallePedidoTipo> listar(){
		return service.listarDetallePedidoTipo();
	}
	@PostMapping
	public DetallePedidoTipo agregar(@RequestBody DetallePedidoTipo p) {
		return service.addDetallePedidoTipo(p);
	}
	
	@GetMapping("/{id}")
	public DetallePedidoTipo listarId(@PathVariable("id")String id){
		return service.listarIdDetallePedidoTipo(id);
	}
	@PutMapping
	public DetallePedidoTipo editar(@RequestBody DetallePedidoTipo p) {
		return service.editDetallePedidoTipo(p);
	}
	@DeleteMapping("/{id}")
	public DetallePedidoTipo delete(@PathVariable("id")String id) {
		return service.deleteDetallePedidoTipo(id);
	}
}
