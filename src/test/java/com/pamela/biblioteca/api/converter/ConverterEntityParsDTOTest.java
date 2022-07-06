package com.pamela.biblioteca.api.converter;

import com.pamela.biblioteca.api.fixture.EmprestimoDTOFixture;
import com.pamela.biblioteca.api.fixture.EmprestimoFixture;
import com.pamela.biblioteca.api.fixture.LivroDTOFixture;
import com.pamela.biblioteca.api.fixture.LivroFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ConverterEntityParsDTOTest {

    @Test
    void converteLivroParaLivroDTO() {
        final var livro = LivroFixture.mockLivro();

        final var livroDTO = ConverterEntityParaDTO.converterLivroParaLivroDTO(livro);

        assertEquals(livro.getId(), livroDTO.getId());
        assertEquals(livro.getTitulo(), livroDTO.getTitulo());
        assertEquals(livro.getAutor(), livroDTO.getAutor());
        assertEquals(livro.getIsbn(), livroDTO.getIsbn());
        assertEquals(livro.getEmprestimo(), livroDTO.getEmprestimo());
    }

    @Test
    void converteLivroDTOParaLivro() {
        final var livroDTO = LivroDTOFixture.mockLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroDTO);

        assertEquals(livroDTO.getId(), livro.getId());
        assertEquals(livroDTO.getTitulo(), livro.getTitulo());
        assertEquals(livroDTO.getAutor(), livro.getAutor());
        assertEquals(livroDTO.getIsbn(), livro.getIsbn());
        assertEquals(livroDTO.getEmprestimo(), livro.getEmprestimo());
    }

    @Test
    void converteEmprestimoParaEmprestimoDTO() {
        final var emprestimo = EmprestimoFixture.mockEmprestimoFixture();

        final var emprestimoDTO = ConverterEntityParaDTO.converterEmprestimoParaDTO(emprestimo);

        assertEquals(emprestimo.getCliente(), emprestimoDTO.getCliente());
        assertEquals(emprestimo.getId(), emprestimoDTO.getId());
        assertEquals(emprestimo.getDataEmprestimo(), emprestimoDTO.getDataEmprestimo());
    }

    @Test
    void converterEmprestimoDTOParaEmprestimo() {
        final var emprestimoDTO = EmprestimoDTOFixture.mockEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoDTO);

        assertEquals(emprestimoDTO.getId(), emprestimo.getId());
        assertEquals(emprestimoDTO.getCliente(), emprestimo.getCliente());
        assertEquals(emprestimoDTO.getDataEmprestimo(), emprestimo.getDataEmprestimo());
    }

}
