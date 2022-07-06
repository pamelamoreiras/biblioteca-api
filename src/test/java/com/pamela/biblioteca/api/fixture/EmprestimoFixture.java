package com.pamela.biblioteca.api.fixture;

import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class EmprestimoFixture {

    public static Emprestimo mockEmprestimoFixture() {
        return Emprestimo.builder()
                .id(2L)
                .cliente("Alef")
                .dataEmprestimo(LocalDate.now())
                .build();
    }

}
