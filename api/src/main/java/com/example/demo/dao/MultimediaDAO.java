package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.model.Multimedia;

public interface MultimediaDAO extends Repository<Multimedia, String>{
	
	List<Multimedia>findAll();
	
	Multimedia findById(String id);
	
	Multimedia save(Multimedia p);
	
	void delete(Multimedia p);
}
