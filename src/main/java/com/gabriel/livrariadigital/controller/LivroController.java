package com.gabriel.livrariadigital.controller;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping(value = "/novoLivro")
    public String getLivroForm() {
        return "livroForm";
    }

    @PostMapping(value = "/novoLivro")
    public String adicionarLivro(@Valid Livro livro, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novoLivro";
        }
        if (livro.isValid(livro.getIsbn()))
            service.save(livro);

        return "redirect:/livros";
    }
}
