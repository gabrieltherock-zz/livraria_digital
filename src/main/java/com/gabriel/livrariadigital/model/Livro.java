package com.gabriel.livrariadigital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LIVROS")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 13)
    private String isbn;

    @NotNull
    @Size(min = 1, max = 50)
    private String titulo;

    @NotNull
    @Size(min = 1, max = 50)
    private String autor;

    @NotNull
    @Size(min = 1, max = 4)
    private Integer ano;

    @NotNull
    @Size(min = 1, max = 2)
    private Integer edicao;

    @NotNull
    @Size(min = 1, max = 50)
    private String editora;

    public boolean isValid(String isbn) {
        String regex = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
        return isbn.matches(regex);
    }
}
