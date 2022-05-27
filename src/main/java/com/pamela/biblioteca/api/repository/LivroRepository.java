package com.pamela.biblioteca.api.repository;

import com.pamela.biblioteca.api.entity.livros.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
