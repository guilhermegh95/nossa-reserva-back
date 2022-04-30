package com.nossareserva.controllers;
import com.nossareserva.UsuarioModel;
import com.nossareserva.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioModel>> getAllUsuario() {
        List<UsuarioModel> usuarioList = usuarioRepository.findAll();
        if(usuarioList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<UsuarioModel>>(usuarioList, HttpStatus.OK);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioModel> getOneUsuario(@PathVariable(value="id") long id) {
        Optional<UsuarioModel> usuarioUnitario = usuarioRepository.findById(id);
        if(!usuarioUnitario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<UsuarioModel>(usuarioUnitario.get(), HttpStatus.OK);
        }
    }


}
