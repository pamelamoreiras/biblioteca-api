package com.pamela.biblioteca.api.controller;

import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import com.pamela.biblioteca.api.service.impl.EmprestimoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoServiceImpl emprestimoService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public EmprestimoDTO salvar (@RequestBody final EmprestimoDTO emprestimoDTO){
        return emprestimoService.salvar(emprestimoDTO);
    }

    @GetMapping("/{id}")
    public EmprestimoDTO buscarPeloId (@PathVariable final Long id){
        return emprestimoService.buscarPorId(id);
    }

    @GetMapping("/nome")
    public EmprestimoDTO buscarPeloNome (@RequestBody final EmprestimoDTO emprestimoDTO){
        return emprestimoService.buscarPorNome(emprestimoDTO);
    }

    @GetMapping("/todos")
    public List<EmprestimoDTO> buscarTodos (final EmprestimoDTO emprestimoDTO){
        return emprestimoService.buscarTodosEmprestimos(emprestimoDTO);
    }

    @DeleteMapping("/{id}")
    public EmprestimoDTO deletarPorId (@PathVariable final Long id){
        return emprestimoService.deletarPorId(id);
    }

    @DeleteMapping("/nome")
    public EmprestimoDTO deletarPorNome (@RequestBody final EmprestimoDTO emprestimoDTO){
        return emprestimoService.deletar(emprestimoDTO);
    }

}
