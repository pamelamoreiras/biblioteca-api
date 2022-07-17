package com.pamela.biblioteca.api.repository;

import com.pamela.biblioteca.api.entity.emprestimos.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {

    Optional<Emprestimo> findByCliente(String cliente);

}
