package com.pamela.biblioteca.api.fixture;

import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class LivroDTOFixture {

    public static LivroDTO mockLivroDTO() {
        return LivroDTO.builder()
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
