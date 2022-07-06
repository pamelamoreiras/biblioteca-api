package com.pamela.biblioteca.api.fixture;

import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class EmprestimoDTOFixture {

    public static EmprestimoDTO mockEmprestimoDTO() {
        return EmprestimoDTO.builder()
                .id(2L)
                .cliente("Alef")
                .dataEmprestimo(LocalDate.now())
                .build();
    }

}
