package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.EstadoLibro;
import com.biblioteca.sistema_biblioteca.model.Libro;
import com.biblioteca.sistema_biblioteca.repository.LibroRepository;
import com.biblioteca.sistema_biblioteca.service.LibroServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibroServiceImplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    @Test
    void cuandoBuscarPorIsbnExiste_entoncesRetornaLibro() {
        String isbn = "123-456-789";
        Libro esperado = new Libro(1L, isbn, "Test Book", "Autor", EstadoLibro.DISPONIBLE);
        when(libroRepository.findByIsbn(isbn)).thenReturn(Optional.of(esperado));

        Libro resultado = libroService.buscarPorIsbn(isbn);

        assertNotNull(resultado);
        assertEquals(isbn, resultado.getIsbn());
        verify(libroRepository).findByIsbn(isbn);
    }

    @Test
    void cuandoBuscarPorIsbnNoExiste_entoncesLanzaExcepcion() {
        String isbn = "no-existe";
        when(libroRepository.findByIsbn(isbn)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> libroService.buscarPorIsbn(isbn));
    }
}
