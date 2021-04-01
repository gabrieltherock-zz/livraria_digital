package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    LivroService service;

    @GetMapping
    public String todosOsLivros(Model model) {
        List<Livro> livros = service.findAll();
        model.addAttribute("livros", livros);
        return "index";
    }
}
