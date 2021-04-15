package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Mensaje;
import com.example.demo.model.Documento;
import com.example.demo.service.CloudinaryService;
import com.example.demo.service.DocumentoService;

@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping({"/documento"})
public class DocumentoController {
	@Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    DocumentoService documentoService;

    @GetMapping("/list")
    public ResponseEntity<List<Documento>> list(){
        List<Documento> list = documentoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile,@PathVariable("id") String id)throws IOException {
    	if(multipartFile.getSize() > 104857600) {
    		return new ResponseEntity(new Mensaje("el documento es muy pesado"), HttpStatus.INSUFFICIENT_STORAGE);
    	}
        Map result = cloudinaryService.uploadDocumento(multipartFile);
		Documento documento =
                new Documento((String) id,
                		(String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        documentoService.save(documento);
        return new ResponseEntity(new Mensaje("documento subido"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id)throws IOException {
        if(!documentoService.exists(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Documento documento = documentoService.getOne(id).get();
        Map result = cloudinaryService.deleteDocumento(documento.getDocumentoid());
        documentoService.delete(id);
        return new ResponseEntity(new Mensaje("documento eliminado"), HttpStatus.OK);
    }
}
