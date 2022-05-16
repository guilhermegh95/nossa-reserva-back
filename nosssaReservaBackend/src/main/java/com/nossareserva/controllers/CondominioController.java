package com.nossareserva.controllers;

import com.nossareserva.CondominioModel;
import com.nossareserva.repositories.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CondominioController {

    @Autowired
    CondominioRepository condominioRepository;

    @CrossOrigin
    @GetMapping("/condominio")
    public ResponseEntity<List<CondominioModel>> getAllCondominio(){
        List<CondominioModel> condominioList = condominioRepository.findAll();
        if(condominioList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<CondominioModel>>(condominioList, HttpStatus.OK);
        }

    }

    @CrossOrigin
    @PostMapping("/condominio")
    public ResponseEntity<CondominioModel> saveReserva(@RequestBody @Validated CondominioModel condominio) {
        return new ResponseEntity<CondominioModel>(condominioRepository.save(condominio), HttpStatus.CREATED);
    }

    @DeleteMapping("/condominio/{id}")
    public ResponseEntity<?> deleteCondominio(@PathVariable(value = "id") long id) {
        Optional<CondominioModel> condominioUnitario = condominioRepository.findById(id);
        if(!condominioUnitario.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            condominioRepository.delete(condominioUnitario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/condominio/{id}")
    public ResponseEntity<CondominioModel> updateReserva(@PathVariable(value = "id") long id,
                                                      @RequestBody @Validated CondominioModel condominio) {
        Optional<CondominioModel> condominioUnitario = condominioRepository.findById(id);
        if(!condominioUnitario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            condominio.setIdCondominio(condominioUnitario.get().getIdCondominio());
            return new ResponseEntity<CondominioModel>(condominioRepository.save(condominio), HttpStatus.OK);
        }
    }
}
