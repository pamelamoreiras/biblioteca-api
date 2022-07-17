package com.pamela.biblioteca.api.dto;

import com.pamela.biblioteca.api.entity.livros.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmprestimoDTO {

    private Long id;

    private String cliente;

    private List<Livro> livros;

    private LocalDate dataEmprestimo;

}
