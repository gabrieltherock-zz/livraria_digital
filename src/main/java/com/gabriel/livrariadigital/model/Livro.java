package com.gabriel.livrariadigital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.validator.routines.ISBNValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LIVROS")
public class Livro {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String isbn;

    @NotNull
    private String titulo;

    @NotNull
    private String autor;

    @NotNull
    private String ano;

    @NotNull
    private String edicao;

    @NotNull
    private String editora;

    public boolean setIsbn(String isbn) {
        ISBNValidator validator = new ISBNValidator();
        return validator.isValidISBN13(isbn);
    }
}
