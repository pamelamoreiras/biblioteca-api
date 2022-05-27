package com.pamela.biblioteca.api.service.impl;

import com.pamela.biblioteca.api.converter.ConverterEntityParaDTO;
import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.repository.LivroRepository;
import com.pamela.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.pamela.biblioteca.api.converter.ConverterEntityParaDTO.converterLivroDTOParaLivro;
import static com.pamela.biblioteca.api.converter.ConverterEntityParaDTO.converterLivroParaLivroDTO;

@Service
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public LivroDTO salvar(final LivroDTO livro) {
        final var converterLivro = converterLivroDTOParaLivro(livro);
        final var salvarLivro = livroRepository.save(converterLivro);

        return converterLivroParaLivroDTO(salvarLivro);
    }

    public LivroDTO alterar(final Long id, final LivroDTO livroDTO) {
        final var livroParaAlterar = livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroDTO.getTitulo());
            livro.setAutor(livroDTO.getAutor());
            livro.setIsbn(livroDTO.getIsbn());
            livro.setEmprestimo(livroDTO.getEmprestimo());

             return converterLivroParaLivroDTO(livro);

        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Livro não encontrado"));

        return livroParaAlterar;

    }

}
