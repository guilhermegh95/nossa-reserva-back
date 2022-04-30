package com.nossareserva.controllers;

import com.nossareserva.ReservaModel;
import com.nossareserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;

    @GetMapping("/reserva")
    public ResponseEntity<List<ReservaModel>> getAllReserva(){
        List<ReservaModel> reservaList = reservaRepository.findAll();
        if(reservaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<ReservaModel>>(reservaList, HttpStatus.OK);
        }

    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<ReservaModel> getOneReserva(@PathVariable(value = "id") long id) {
        Optional<ReservaModel> reservaUnitaria = reservaRepository.findById(id);
        if (!reservaUnitaria.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<ReservaModel>(reservaUnitaria.get(), HttpStatus.OK);
        }
    }
}
