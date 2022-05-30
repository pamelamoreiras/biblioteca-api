package com.pamela.biblioteca.api.entity.livros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String autor;

    private String isbn;

//    @OneToMany
//    @JoinColumn(name = "emprestimo_id")
//    private List<Livro> emprestimo;

}
