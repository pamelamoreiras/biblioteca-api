package com.pamela.biblioteca.api.entity.emprestimos;

import com.pamela.biblioteca.api.entity.livros.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Emprestimo {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String cliente;

    @OneToMany(mappedBy = "emprestimo")
    @JoinColumn(name = "livro_id")
    private List<Livro> livros;

    //   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yy")
    private LocalDate dataEmprestimo;

}
