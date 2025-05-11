package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.EstadoLibro;
import com.biblioteca.sistema_biblioteca.model.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LibroRepositoryImplTest {

    private LibroRepositoryImpl libroRepository;

    @BeforeEach
    void setUp() {
        libroRepository = new LibroRepositoryImpl();
    }

    @Test
    void guardarYBuscarPorId_funcionaCorrectamente() {
        Libro libro = new Libro(null, "123", "Título", "Autor", EstadoLibro.DISPONIBLE);
        Libro guardado = libroRepository.save(libro);

        Optional<Libro> resultado = libroRepository.findById(guardado.getId());

        assertTrue(resultado.isPresent());
        assertEquals("123", resultado.get().getIsbn());
    }

    @Test
    void eliminarPorId_quitaElLibro() {
        Libro libro = new Libro(null, "999", "Eliminar", "Autor", EstadoLibro.PRESTADO);
        Libro guardado = libroRepository.save(libro);

        libroRepository.deleteById(guardado.getId());

        Optional<Libro> resultado = libroRepository.findById(guardado.getId());
        assertFalse(resultado.isPresent());
    }

    @Test
    void existePorId_devuelveTrueSiExiste() {
        Libro libro = new Libro(null, "456", "Existente", "Autor", EstadoLibro.DISPONIBLE);
        Libro guardado = libroRepository.save(libro);

        boolean existe = libroRepository.existsById(guardado.getId());
        assertTrue(existe);
    }
}
