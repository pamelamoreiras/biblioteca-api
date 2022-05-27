package com.pamela.biblioteca.api.dto;

import com.pamela.biblioteca.api.entity.livros.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroDTO {

    private String titulo;

    private String autor;

    private String isbn;

    private List<Livro> emprestimo;

}
