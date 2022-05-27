package com.pamela.biblioteca.api.dto;

import com.pamela.biblioteca.api.entity.livros.Livro;

import java.util.List;

public class LivroDTO {

    private String titulo;

    private String autor;

    private String isbn;

    private List<Livro> emprestimo;

}
