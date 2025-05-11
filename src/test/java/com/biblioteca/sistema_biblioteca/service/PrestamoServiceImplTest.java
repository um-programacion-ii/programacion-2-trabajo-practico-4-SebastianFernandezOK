package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.Prestamo;
import com.biblioteca.sistema_biblioteca.repository.PrestamoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceImplTest {

    @Mock
    private PrestamoRepository prestamoRepository;

    @InjectMocks
    private PrestamoServiceImpl prestamoService;

    @Test
    void cuandoBuscarPorIdExiste_entoncesRetornaPrestamo() {
        Long id = 1L;
        Prestamo esperado = new Prestamo(id, null, null, LocalDate.now(), null);
        when(prestamoRepository.findById(id)).thenReturn(Optional.of(esperado));

        Prestamo resultado = prestamoService.buscarPorId(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        verify(prestamoRepository).findById(id);
    }

    @Test
    void cuandoBuscarPorIdNoExiste_entoncesLanzaExcepcion() {
        Long id = 99L;
        when(prestamoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> prestamoService.buscarPorId(id));
    }
}
