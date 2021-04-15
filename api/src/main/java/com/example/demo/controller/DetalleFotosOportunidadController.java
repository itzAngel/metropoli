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

import com.example.demo.model.DetalleFotosOportunidad;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleFotosOportunidad"})
public class DetalleFotosOportunidadController {
	@Autowired
	MetroService service;
	
	@GetMapping
	public List<DetalleFotosOportunidad> listar(){
		return service.listarDetalleFotosOportunidad();
	}
	@PostMapping
	public DetalleFotosOportunidad agregar(@RequestBody DetalleFotosOportunidad p) {
		return service.addDetalleFotosOportunidad(p);
	}
	
	@GetMapping("/{id}")
	public DetalleFotosOportunidad listarId(@PathVariable("id")String id){
		return service.listarIdDetalleFotosOportunidad(id);
	}
	@PutMapping
	public DetalleFotosOportunidad editar(@RequestBody DetalleFotosOportunidad p) {
		return service.editDetalleFotosOportunidad(p);
	}
	@DeleteMapping("/{id}")
	public DetalleFotosOportunidad delete(@PathVariable("id")String id) {
		return service.deleteDetalleFotosOportunidad(id);
	}
}
