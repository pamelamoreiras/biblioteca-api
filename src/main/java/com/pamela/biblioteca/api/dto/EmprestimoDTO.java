package com.pamela.biblioteca.api.dto;

import com.pamela.biblioteca.api.entity.livros.Livro;

import java.time.LocalDate;

public class EmprestimoDTO {

    private String cliente;

    private Livro livro;

    private LocalDate dataEmprestimo;

}
