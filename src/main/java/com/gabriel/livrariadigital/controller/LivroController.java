package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    LivroService service;

}
