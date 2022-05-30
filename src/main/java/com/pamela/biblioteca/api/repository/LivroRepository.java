package com.pamela.biblioteca.api.repository;

import com.pamela.biblioteca.api.entity.livros.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    Optional<Livro> findByTitulo(String titulo);

    Optional<Livro> findByIsbn (String isbn);

}
