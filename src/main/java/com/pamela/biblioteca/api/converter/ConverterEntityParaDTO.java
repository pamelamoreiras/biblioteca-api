package com.pamela.biblioteca.api.converter;

import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import com.pamela.biblioteca.api.dto.LivroDTO;
import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import com.pamela.biblioteca.api.entity.livros.Livro;

public class ConverterEntityParaDTO {

    public static LivroDTO converterLivroParaLivroDTO(final Livro livro) {
        return LivroDTO.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .isbn(livro.getIsbn())
                .emprestimo(livro.getEmprestimo())
                .build();
    }

    public static Livro converterLivroDTOParaLivro(final LivroDTO livroDTO) {
        return Livro.builder()
                .id(livroDTO.getId())
                .titulo(livroDTO.getTitulo())
                .autor(livroDTO.getAutor())
                .isbn(livroDTO.getIsbn())
                .emprestimo(livroDTO.getEmprestimo())
                .build();
    }

    public static EmprestimoDTO converterEmprestimoParaDTO(final Emprestimo emprestimo) {
        return EmprestimoDTO.builder()
                .id(emprestimo.getId())
                .cliente(emprestimo.getCliente())
//                .livros(emprestimo.getLivros())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .build();
    }

    public static Emprestimo converterDTOParaEmprestimo(final EmprestimoDTO emprestimoDTO) {
        return Emprestimo.builder()
                .id(emprestimoDTO.getId())
                .cliente(emprestimoDTO.getCliente())
                //.livros(emprestimoDTO.getLivros())
                .dataEmprestimo(emprestimoDTO.getDataEmprestimo())
                .build();
    }

//    public static List<EmprestimoDTO> converteListParaListDTO (List<Emprestimo> listaEmprestimo){
//
//    }


}
