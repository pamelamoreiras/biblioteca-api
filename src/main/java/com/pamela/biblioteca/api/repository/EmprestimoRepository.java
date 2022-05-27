package com.pamela.biblioteca.api.repository;

import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
}
