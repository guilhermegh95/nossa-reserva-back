package com.nossareserva.controllers;

import com.nossareserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;
}
