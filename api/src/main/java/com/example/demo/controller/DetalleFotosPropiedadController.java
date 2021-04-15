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

import com.example.demo.model.DetalleFotosPropiedad;
import com.example.demo.service.MetroService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/detalleFotosPropiedad"})
public class DetalleFotosPropiedadController {
	@Autowired
	MetroService service;
	
	@GetMapping("/listar")
	public List<DetalleFotosPropiedad> listar(){
		return service.listarDetalleFotosPropiedad();
	}
	@GetMapping("/listarPorPropiedad/{id}")
	public List<DetalleFotosPropiedad> listarxPropiedad(@PathVariable("id")String id){
		return service.listarDetalleporPropiedad(id);
	}
	@PostMapping
	public DetalleFotosPropiedad agregar(@RequestBody DetalleFotosPropiedad p) {
		return service.addDetalleFotosPropiedad(p);
	}
	
	@GetMapping("/{id}")
	public DetalleFotosPropiedad listarId(@PathVariable("id")String id){
		return service.listarIdDetalleFotosPropiedad(id);
	}
	@PutMapping
	public DetalleFotosPropiedad editar(@RequestBody DetalleFotosPropiedad p) {
		return service.editDetalleFotosPropiedad(p);
	}
	@DeleteMapping("/{id}")
	public DetalleFotosPropiedad delete(@PathVariable("id")String id) {
		return service.deleteDetalleFotosPropiedad(id);
	}
}
