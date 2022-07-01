package com.pamela.biblioteca.api.service.impl;

import com.pamela.biblioteca.api.converter.ConverterEntityParaDTO;
import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import com.pamela.biblioteca.api.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LivroServiceImplTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroServiceImpl livroServiceImpl;

    @Test
    void quandoForInformadoOsDadosDoLivroDeveRetornarLivroDTOSalvo() {

        // DADO um livro criado na base de dados
        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        final var livroParaLivroDTO = ConverterEntityParaDTO.converterLivroParaLivroDTO(livro);

        Mockito.when(livroRepository.save(livro)).thenReturn(livro);

        final var result = livroServiceImpl.salvar(livroParaLivroDTO);

        assertNotNull(result);
        assertEquals(livro.getId(), result.getId());
        assertEquals(livro.getEmprestimo(), result.getEmprestimo());
        assertEquals(livro.getAutor(), result.getAutor());
        assertEquals(livro.getIsbn(), result.getIsbn());
        assertEquals(livro.getTitulo(), result.getTitulo());
    }


    @Test
    void quandoForInformadoUmIdValidoEOsDadosDeUmLivroRetornaOLivroDtoAlretado() {

        final var idValido = 2L;

        final var livroCriado = this.criaLivroDTO();

        livroCriado.setAutor("ALEF");
        livroCriado.setTitulo("Tormenta");
        livroCriado.setIsbn("9876");
        livroCriado.setEmprestimo(Emprestimo.builder()
                .id(2L)
                .cliente("Viviane")
                .dataEmprestimo(LocalDate.now())
                .build());

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findById(Mockito.any())).thenReturn(Optional.of(livro));
        Mockito.when(livroRepository.save(livro)).thenReturn(livro);

        final var result = livroServiceImpl.alterar(idValido, livroCriado);

        assertNotNull(result);
        assertEquals("ALEF", livroCriado.getAutor());

    }

    @Test
    void quandoForInformadoUmIdValidoDeveSerRetornadoUmLivroDto() {
        //DADO que eu tenha um id válido
        final var idValido = 2L;

        //E tenha um livro na minha base de dados com o ID anterior
        final var livroEncontrado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroEncontrado);

        //E o método que busca um livro pelo id é acionado
        Mockito.when(livroRepository.findById(Mockito.any())).thenReturn(Optional.of(livro));

        //QUANDO o meu método encontrar livro por id do livro service impl for acionado
        final var result = livroServiceImpl.encontrarLivroPorId(idValido);

        //ENTÃO eu garanto que foi devolvido um livro com sucesso através das assertivas abaixo
        assertNotNull(result);
        assertEquals(result.getId(), idValido);

    }

    @Test
    void quandoForInformadoONomeDoLivroRetornaUmLivroDTO() {
        final var nomeValido = "Fallen";

        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findByTitulo(nomeValido)).thenReturn(Optional.of(livro));

        final var result = livroServiceImpl.encontrarLivroPorNome(livroCriado);

        assertNotNull(result);
        assertEquals(livro.getTitulo(), result.getTitulo());
    }

    @Test
    void retornarTodos() {
        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findAll()).thenReturn(List.of(livro));

        final var result = livroServiceImpl.encontrarTodosLivros(livroCriado);

        assertNotNull(result);
    }

    @Test
    void quandoForInformadoIsbnDoLivroRetornaUmLivroDTO() {
        final var isbnValido = "1234";

        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findByIsbn(isbnValido)).thenReturn(Optional.of(livro));

        final var result = livroServiceImpl.encontrarPorIsbn(livroCriado);

        assertNotNull(result);
        assertEquals(livro.getIsbn(), result.getIsbn());
    }

    @Test
    void quandoForInformadoIdValidoRetornalivroDeletado() {
        final var idValido = 5L;

        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findById(idValido)).thenReturn(Optional.of(livro));
        Mockito.doNothing().when(livroRepository).delete(livro);

        final var result = livroServiceImpl.deletarLivroPorId(idValido);

        assertNotNull(result);
        assertEquals(livro.getId(), result.getId());

    }

    @Test
    void quandoForInformadoIsbnDeletarOLivro() {
        final var isbnValido = "1234";

        final var livroCriado = this.criaLivroDTO();

        final var livro = ConverterEntityParaDTO.converterLivroDTOParaLivro(livroCriado);

        Mockito.when(livroRepository.findByIsbn(isbnValido)).thenReturn(Optional.of(livro));
        Mockito.doNothing().when(livroRepository).delete(livro);

        final var result = livroServiceImpl.deletarPorIsbn(livroCriado);

        assertNotNull(result);
        assertEquals(livro.getIsbn(), result.getIsbn());
    }

    private LivroDTO criaLivroDTO() {
        return LivroDTO.builder()
                .id(2L)
                .titulo("Fallen")
                .autor("Pamela")
                .isbn("1234")
                .emprestimo(Emprestimo.builder()
                        .id(3L)
                        .dataEmprestimo(LocalDate.now())
                        .cliente("Alef")
                        .build())
                .build();
    }

}
