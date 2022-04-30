package com.nossareserva.controllers;

import com.nossareserva.repositories.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaComumController {

    @Autowired
    AreaComumRepository areaComumRepository;
}
