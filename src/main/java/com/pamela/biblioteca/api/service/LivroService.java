package com.pamela.biblioteca.api.service;

import com.pamela.biblioteca.api.dto.LivroDTO;

import java.util.List;

public interface LivroService {

    LivroDTO salvar (LivroDTO livro);

    LivroDTO alterar(Long id, LivroDTO livroDTO);

    LivroDTO encontrarLivroPorId(Long id);

    LivroDTO deletarLivroPorId(Long id);

    LivroDTO encontrarLivroPorNome(LivroDTO livroDTO);

    List<LivroDTO> EncontrarTodosLivros (LivroDTO livroDTO);

    LivroDTO encontrarPorIsbn ( LivroDTO livroDTO);

    LivroDTO deletarPorIsbn(LivroDTO livroDTO);
}
