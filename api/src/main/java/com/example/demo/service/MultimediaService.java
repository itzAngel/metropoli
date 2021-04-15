package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MultimediaRepository;
import com.example.demo.model.Multimedia;

@Service
@Transactional
public class MultimediaService {

    @Autowired
    MultimediaRepository multimediaRepository;

    public List<Multimedia> list(){
        return multimediaRepository.findByOrderById();
    }

    public Optional<Multimedia> getOne(String id){
        return multimediaRepository.findById(id);
    }

    public void save(Multimedia multimedia){
    	multimediaRepository.save(multimedia);
    }

    public void delete(String id){
    	multimediaRepository.deleteById(id);
    }

    public boolean exists(String id){
        return multimediaRepository.existsById(id);
    }
}