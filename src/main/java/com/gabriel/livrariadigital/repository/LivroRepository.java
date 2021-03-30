package com.gabriel.livrariadigital.repository;

import com.gabriel.livrariadigital.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByIsbn(String isbn);
}
