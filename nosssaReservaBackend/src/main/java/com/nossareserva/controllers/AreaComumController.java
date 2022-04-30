package com.nossareserva.controllers;
import com.nossareserva.AreaComumModel;
import com.nossareserva.repositories.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
