package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LivroController {

    @Autowired
    LivroService service;

}
