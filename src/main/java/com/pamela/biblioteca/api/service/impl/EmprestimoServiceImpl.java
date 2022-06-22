package com.pamela.biblioteca.api.service.impl;

import com.pamela.biblioteca.api.converter.ConverterEntityParaDTO;
import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import com.pamela.biblioteca.api.repository.EmprestimoRepository;
import com.pamela.biblioteca.api.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Override
    public EmprestimoDTO salvar(final EmprestimoDTO emprestimoDTO) {
        var emprestimoParaSalvar = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoDTO);
        var salvandoEmprestimo = emprestimoRepository.save(emprestimoParaSalvar);

        return ConverterEntityParaDTO.converterEmprestimoParaDTO(salvandoEmprestimo);
    }

    @Override
    public EmprestimoDTO buscarPorId(final Long id) {
        return emprestimoRepository.findById(id)
                .map(ConverterEntityParaDTO::converterEmprestimoParaDTO)
                .orElseThrow();
    }

    @Override
    public EmprestimoDTO buscarPorNome(final EmprestimoDTO emprestimoDTO) {
        var paraEncontrar = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoDTO);
        return emprestimoRepository.findByCliente(emprestimoDTO.getCliente())
                .map(ConverterEntityParaDTO::converterEmprestimoParaDTO).orElseThrow();

    }

    @Override
    public List<EmprestimoDTO> buscarTodosEmprestimos(final EmprestimoDTO emprestimoDTO) {
        var paraEncontrar = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoDTO);
        return emprestimoRepository.findAll()
                .stream()
                .map(ConverterEntityParaDTO::converterEmprestimoParaDTO)
                .collect(Collectors.toList());

    }

    @Override
    public EmprestimoDTO deletarPorId(final Long id) {
        return emprestimoRepository.findById(id)
                .map(emprestimo -> {emprestimoRepository.delete(emprestimo); return emprestimo; })
                .map(ConverterEntityParaDTO::converterEmprestimoParaDTO)
                .orElseThrow();

    }

    @Override
    public EmprestimoDTO deletar(final EmprestimoDTO emprestimoDTO) {
        var paraEncontrar = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoDTO);
        return emprestimoRepository.findByCliente(paraEncontrar.getCliente())
                .map(emprestimo -> {emprestimoRepository.delete(emprestimo); return emprestimo; })
                .map(ConverterEntityParaDTO::converterEmprestimoParaDTO)
                .orElseThrow();

    }



}
