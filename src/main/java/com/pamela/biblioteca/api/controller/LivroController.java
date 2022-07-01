package com.pamela.biblioteca.api.controller;

import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/salvar")
    public LivroDTO salvarLivro(@RequestBody final LivroDTO livroDTO) {
        return livroService.salvar(livroDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO alterarLivro(@PathVariable final Long id, @RequestBody final LivroDTO livroDTO) {
        return livroService.alterar(id, livroDTO);
    }

    @GetMapping("/{id}")
    public LivroDTO buscarPorId(@PathVariable final Long id) {
        return livroService.encontrarLivroPorId(id);
    }

    @GetMapping("/nome")
    public LivroDTO buscarPorTitulo(@RequestBody final LivroDTO livroDTO) {
        return livroService.encontrarLivroPorNome(livroDTO);
    }

    @GetMapping("/isbn")
    public LivroDTO buscarPorIsbn(@RequestBody final LivroDTO livroDTO) {
        return livroService.encontrarPorIsbn(livroDTO);
    }

    @GetMapping("/buscartodos")
    public List<LivroDTO> buscarTodosLivros(final LivroDTO livroDTO) {
        return livroService.encontrarTodosLivros(livroDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable final Long id) {
        livroService.deletarLivroPorId(id);
    }

    @DeleteMapping("/deletarporisbn")
    public void deletarPorIsbn(@RequestBody final LivroDTO livroDTO) {
        livroService.deletarPorIsbn(livroDTO);
    }

}
