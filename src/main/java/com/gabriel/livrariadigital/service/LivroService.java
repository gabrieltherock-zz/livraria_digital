package com.gabriel.livrariadigital.service;

import com.gabriel.livrariadigital.model.Livro;
import com.gabriel.livrariadigital.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    public Livro findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }
}