package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.DetalleFotosPropiedad;

public interface DetalleFotosPropiedadDAO extends Repository<DetalleFotosPropiedad, String>{
	
	List<DetalleFotosPropiedad>findAll();
	
	DetalleFotosPropiedad findById(String id);
	
	DetalleFotosPropiedad save(DetalleFotosPropiedad p);
	
	void delete(DetalleFotosPropiedad p);
}
