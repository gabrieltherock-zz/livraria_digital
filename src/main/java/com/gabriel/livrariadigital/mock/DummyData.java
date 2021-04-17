package com.gabriel.livrariadigital.mock;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DummyData {

    @Autowired
    LivroService service;

//    @PostConstruct
    public void salvaLivro() {
        Livro livro = new Livro();
        livro.setIsbn("9780267401383");
        livro.setAutor("Gabriel");
        livro.setTitulo("O Estagiário");
        livro.setAno(2021);
        livro.setEdicao(1);
        livro.setEditora("Aleph");

        service.save(livro);
    }
}
