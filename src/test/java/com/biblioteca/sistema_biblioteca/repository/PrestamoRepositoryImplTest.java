package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.Prestamo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoRepositoryImplTest {

    private PrestamoRepositoryImpl prestamoRepository;

    @BeforeEach
    void setUp() {
        prestamoRepository = new PrestamoRepositoryImpl();
    }

    @Test
    void guardarYBuscarPorId_funcionaCorrectamente() {
        Prestamo prestamo = new Prestamo(null, null, null, LocalDate.now(), null);
        Prestamo guardado = prestamoRepository.save(prestamo);

        Optional<Prestamo> resultado = prestamoRepository.findById(guardado.getId());

        assertTrue(resultado.isPresent());
        assertEquals(guardado.getId(), resultado.get().getId());
    }

    @Test
    void eliminarPorId_quitaElPrestamo() {
        Prestamo prestamo = new Prestamo(null, null, null, LocalDate.now(), null);
        Prestamo guardado = prestamoRepository.save(prestamo);

        prestamoRepository.deleteById(guardado.getId());

        Optional<Prestamo> resultado = prestamoRepository.findById(guardado.getId());
        assertFalse(resultado.isPresent());
    }

    @Test
    void existePorId_devuelveTrueSiExiste() {
        Prestamo prestamo = new Prestamo(null, null, null, LocalDate.now(), null);
        Prestamo guardado = prestamoRepository.save(prestamo);

        assertTrue(prestamoRepository.existsById(guardado.getId()));
    }
}
