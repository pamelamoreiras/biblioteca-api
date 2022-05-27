package com.pamela.biblioteca.api.dto;

import com.pamela.biblioteca.api.entity.livros.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmprestimoDTO {

    private String cliente;

    private Livro livro;

    private LocalDate dataEmprestimo;

}
