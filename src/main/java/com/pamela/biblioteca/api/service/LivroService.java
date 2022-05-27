package com.pamela.biblioteca.api.service;

import com.pamela.biblioteca.api.dto.LivroDTO;

public interface LivroService {

    LivroDTO salvar (LivroDTO livro);

    LivroDTO alterar(Long id, LivroDTO livroDTO);
}
