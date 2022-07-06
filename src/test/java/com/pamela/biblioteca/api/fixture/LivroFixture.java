package com.pamela.biblioteca.api.fixture;

import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import com.pamela.biblioteca.api.entity.livros.Livro;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class LivroFixture {

    public static Livro mockLivro() {
        return Livro.builder()
                .titulo("Fallen")
                .autor("Pamela")
                .id(3L)
                .isbn("1234")
                .emprestimo(Emprestimo.builder()
                        .cliente("Alef")
                        .id(2L)
                        .dataEmprestimo(LocalDate.now())
                        .build())
                .build();
    }

}
