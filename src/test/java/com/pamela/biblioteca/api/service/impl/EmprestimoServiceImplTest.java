package com.pamela.biblioteca.api.service.impl;

import com.pamela.biblioteca.api.converter.ConverterEntityParaDTO;
import com.pamela.biblioteca.api.dto.EmprestimoDTO;
import com.pamela.biblioteca.api.repository.EmprestimoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceImplTest {

    @Mock
    EmprestimoRepository emprestimoRepository;

    @InjectMocks
    EmprestimoServiceImpl emprestimoServiceImpl;

    @Test
    void quandoReceberOsDadosDoEmprestimoRetornaEmprestimoDTO() {

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.save(emprestimo)).thenReturn(emprestimo);

        final var result = emprestimoServiceImpl.salvar(emprestimoCriado);

        assertNotNull(result);
        assertEquals(emprestimoCriado.getId(), result.getId());

    }

    @Test
    void quandoReceberIdRetornaEmprestimoDTO() {

        final var idValido = 3L;

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.findById(idValido)).thenReturn(Optional.of(emprestimo));

        final var result = emprestimoServiceImpl.buscarPorId(idValido);

        assertNotNull(result);
        assertEquals(emprestimoCriado.getId(), result.getId());

    }

    @Test
    void quandoReceberClienteRetornaEmprestimoDTO() {

        final var clienteValido = "Viviane";

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.findByCliente(clienteValido)).thenReturn(Optional.of(emprestimo));

        final var result = emprestimoServiceImpl.buscarPorNome(emprestimoCriado);

        assertNotNull(result);
        assertEquals(emprestimoCriado.getCliente(), result.getCliente());

    }

    @Test
    void retornaTodosOsEmprestimos() {

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.findAll()).thenReturn(List.of(emprestimo));

        final var result = emprestimoServiceImpl.buscarTodosEmprestimos(emprestimoCriado);

        assertNotNull(result);

    }

    @Test
    void quandoInformarIdDeletaEmprestimo() {

        final var idValido = 3L;

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.findById(idValido)).thenReturn(Optional.of(emprestimo));
        Mockito.doNothing().when(emprestimoRepository).delete(emprestimo);

        final var result = emprestimoServiceImpl.deletarPorId(idValido);

        assertNotNull(result);
        assertEquals(emprestimo.getCliente(), result.getCliente());

    }

    @Test
    void quandoInformarClienteDeletaEmprestimoDTO() {

        final var clienteValido = "Viviane";

        final var emprestimoCriado = this.criarEmprestimoDTO();

        final var emprestimo = ConverterEntityParaDTO.converterDTOParaEmprestimo(emprestimoCriado);

        Mockito.when(emprestimoRepository.findByCliente(clienteValido)).thenReturn(Optional.of(emprestimo));
        Mockito.doNothing().when(emprestimoRepository).delete(emprestimo);

        final var result = emprestimoServiceImpl.deletar(emprestimoCriado);

        assertNotNull(result);
        assertEquals(emprestimo.getCliente(), result.getCliente());

    }

    private EmprestimoDTO criarEmprestimoDTO() {
        return EmprestimoDTO.builder()
                .id(3L)
                .cliente("Viviane")
                .dataEmprestimo(LocalDate.now())
                .build();
    }

}
