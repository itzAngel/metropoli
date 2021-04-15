package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Imagen;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, String> {
    List<Imagen> findByOrderById();
}