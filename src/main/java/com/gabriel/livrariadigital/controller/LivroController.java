package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LivroController {

    @Autowired
    LivroService service;

    @GetMapping(value = "/livros")
    public ModelAndView todosOsLivros() {
        ModelAndView mv = new ModelAndView("livros");
        List<Livro> livros = service.findAll();
        mv.addObject("livros", livros);
        return mv;
    }

    @GetMapping(value = "/novolivro")
    public String getLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "livroForm";
    }

    @PostMapping(value = "/novolivro")
    public String adicionarLivro(@Valid Livro livro,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/livros";
        }
        service.save(livro);
        return "redirect:/livros";
    }
}
