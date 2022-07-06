package com.pamela.biblioteca.api.service;

import com.pamela.biblioteca.api.dto.EmprestimoDTO;

import java.util.List;

public interface EmprestimoService {

    EmprestimoDTO salvar(EmprestimoDTO emprestimoDTO);

    EmprestimoDTO buscarPorId(Long id);

    EmprestimoDTO buscarPorNome(EmprestimoDTO emprestimoDTO);

    List<EmprestimoDTO> buscarTodosEmprestimos(EmprestimoDTO emprestimoDTO);

    EmprestimoDTO deletarPorId(Long id);

    EmprestimoDTO deletar(EmprestimoDTO emprestimoDTO);


}
