package com.pamela.biblioteca.api.converter;

import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import com.pamela.biblioteca.api.entity.livros.Livro;

public class ConverterEntityParaDTO {

    public static LivroDTO converterLivroParaLivroDTO( Livro livro){
        return LivroDTO.builder()
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .isbn(livro.getIsbn())
                .emprestimo(livro.getEmprestimo())
                .build();
    }

    public static Livro converterLivroDTOParaLivro (LivroDTO livroDTO){
        return Livro.builder()
                .titulo(livroDTO.getTitulo())
                .autor(livroDTO.getAutor())
                .isbn(livroDTO.getIsbn())
                .emprestimo(livroDTO.getEmprestimo())
                .build();
    }

    public static EmprestimoDTO converterEmprestimoParaDTO(Emprestimo emprestimo){
        return EmprestimoDTO.builder()
                .cliente(emprestimo.getCliente())
                .livro(emprestimo.getLivro())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .build();
    }

    public static Emprestimo converterDTOParaEmprestimo(EmprestimoDTO emprestimoDTO){
        return Emprestimo.builder()
                .cliente(emprestimoDTO.getCliente())
                .livro(emprestimoDTO.getLivro())
                .dataEmprestimo(emprestimoDTO.getDataEmprestimo())
                .build();
    }

}
