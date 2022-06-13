package com.nossareserva.controllers;

import com.nossareserva.model.ReservaModel;
import com.nossareserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/reserva")
    public ResponseEntity<ReservaModel> saveReserva(@RequestBody @Validated ReservaModel reserva) {
        return new ResponseEntity<ReservaModel>(reservaRepository.save(reserva), HttpStatus.CREATED);
    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<?> deleteReserva(@PathVariable(value = "id") long id) {
        Optional<ReservaModel> reservaUnitaria = reservaRepository.findById(id);
        if(!reservaUnitaria.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            reservaRepository.delete(reservaUnitaria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/reserva/{id}")
    public ResponseEntity<ReservaModel> updateReserva(@PathVariable(value = "id") long id,
                                                      @RequestBody @Validated ReservaModel reserva) {
        Optional<ReservaModel> reservaUnitaria = reservaRepository.findById(id);
        if(!reservaUnitaria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            reserva.setIdReserva(reservaUnitaria.get().getIdReserva());
            return new ResponseEntity<ReservaModel>(reservaRepository.save(reserva), HttpStatus.OK);
        }
    }
}
