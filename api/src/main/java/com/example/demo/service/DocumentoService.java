package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DocumentoRepository;
import com.example.demo.model.Documento;

@Service
@Transactional
public class DocumentoService {

    @Autowired
    DocumentoRepository documentoRepository;

    public List<Documento> list(){
        return documentoRepository.findByOrderById();
    }

    public Optional<Documento> getOne(String id){
        return documentoRepository.findById(id);
    }

    public void save(Documento multimedia){
    	documentoRepository.save(multimedia);
    }

    public void delete(String id){
    	documentoRepository.deleteById(id);
    }

    public boolean exists(String id){
        return documentoRepository.existsById(id);
    }
}