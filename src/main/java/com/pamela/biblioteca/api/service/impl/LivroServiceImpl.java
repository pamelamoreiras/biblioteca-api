package com.pamela.biblioteca.api.service.impl;

import com.pamela.biblioteca.api.converter.ConverterEntityParaDTO;
import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.repository.LivroRepository;
import com.pamela.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.pamela.biblioteca.api.converter.ConverterEntityParaDTO.converterLivroDTOParaLivro;
import static com.pamela.biblioteca.api.converter.ConverterEntityParaDTO.converterLivroParaLivroDTO;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public LivroDTO salvar(final LivroDTO livro) {
        final var converterLivro = converterLivroDTOParaLivro(livro);
        final var salvarLivro = livroRepository.save(converterLivro);

        return converterLivroParaLivroDTO(salvarLivro);
    }

    @Override
    public LivroDTO alterar(final Long id, final LivroDTO livroDTO) {
        final var livroParaAlterar = livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroDTO.getTitulo());
            livro.setAutor(livroDTO.getAutor());
            livro.setIsbn(livroDTO.getIsbn());
            livro.setEmprestimo(livroDTO.getEmprestimo());

            final var salvarLivroAlterado = livroRepository.save(livro);

            return converterLivroParaLivroDTO(salvarLivroAlterado);

        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

        return livroParaAlterar;

    }

    @Override
    public LivroDTO encontrarLivroPorId(final Long id) {
        return livroRepository.findById(id)
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro Não Encontrado!"));
    }

    @Override
    public LivroDTO encontrarLivroPorNome(final LivroDTO livroDTO) {
        return livroRepository.findByTitulo(livroDTO.getTitulo())
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

    }

    @Override
    public List<LivroDTO> encontrarTodosLivros(final LivroDTO livroDTO) {
        return livroRepository.findAll()
                .stream()
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO encontrarPorIsbn(final LivroDTO livroDTO) {
        return livroRepository.findByIsbn(livroDTO.getIsbn())
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    @Override
    public LivroDTO deletarLivroPorId(final Long id) {
        return livroRepository.findById(id)
                .map(livro -> {
                    livroRepository.delete(livro);
                    return livro;
                })
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    @Override
    public LivroDTO deletarPorIsbn(final LivroDTO livroDTO) {
        return livroRepository.findByIsbn(livroDTO.getIsbn())
                .map(livro -> {
                    livroRepository.delete(livro);
                    return livro;
                })
                .map(ConverterEntityParaDTO::converterLivroParaLivroDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não Encontrado!"));
    }

}
