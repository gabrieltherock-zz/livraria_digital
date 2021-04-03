package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    LivroService service;

    @GetMapping(value="/livros")
    public ModelAndView todosOsLivros() {
        ModelAndView mv = new ModelAndView("livros");
        List<Livro> livros = service.findAll();
        mv.addObject("livros", livros);
        return mv;
    }
}
