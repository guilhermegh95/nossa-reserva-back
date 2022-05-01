package com.nossareserva.controllers;
import com.nossareserva.AreaComumModel;
import com.nossareserva.repositories.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AreaComumController {

    @Autowired
    AreaComumRepository areaComumRepository;

    @GetMapping("areacomum")
    public ResponseEntity<List<AreaComumModel>> getAllAreaComum() {
        List<AreaComumModel> areaComumList = areaComumRepository.findAll();
        if(areaComumList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<AreaComumModel>>(areaComumList, HttpStatus.OK);
        }
    }

    @GetMapping("/areacomum/{id}")
    public ResponseEntity<AreaComumModel> getOneAreaComum(@PathVariable(value = "id") long id) {
        Optional<AreaComumModel> areaComumUnidade = areaComumRepository.findById(id);
        if(areaComumUnidade.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<AreaComumModel>(areaComumUnidade.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/areacomum")
    public ResponseEntity<AreaComumModel> saveAreaComum(@RequestBody @Validated AreaComumModel areaComum){
        return new ResponseEntity<AreaComumModel>(areaComumRepository.save(areaComum), HttpStatus.CREATED);
    }

    @DeleteMapping("/areacomum/{id}")
    public ResponseEntity<?> deleteAreaComum(@PathVariable(value = "id") long id) {
        Optional<AreaComumModel> areaComumUnitaria = areaComumRepository.findById(id);
        if(!areaComumUnitaria.isPresent()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            areaComumRepository.delete(areaComumUnitaria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/areacomum/{id}")
    public ResponseEntity<AreaComumModel> updateAreaComum(@PathVariable (value = "id") long id,
                                                          @RequestBody @Validated AreaComumModel areaComum) {
        Optional<AreaComumModel> areaComumUnitaria = areaComumRepository.findById(id);
        if(!areaComumUnitaria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            areaComum.setIdAreaComum(areaComumUnitaria.get().getIdAreaComum());
            return new ResponseEntity<AreaComumModel>(areaComumRepository.save(areaComum), HttpStatus.OK);
        }
    }
}
