package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.EstadoUsuario;
import com.biblioteca.sistema_biblioteca.model.Usuario;
import com.biblioteca.sistema_biblioteca.repository.UsuarioRepository;
import com.biblioteca.sistema_biblioteca.service.UsuarioServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    void cuandoBuscarPorIdExiste_entoncesRetornaUsuario() {
        Long id = 1L;
        Usuario esperado = new Usuario(id, "Juan", "juan@example.com", EstadoUsuario.ACTIVO);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(esperado));

        Usuario resultado = usuarioService.buscarPorId(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        verify(usuarioRepository).findById(id);
    }

    @Test
    void cuandoBuscarPorIdNoExiste_entoncesLanzaExcepcion() {
        Long id = 99L;
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> usuarioService.buscarPorId(id));
    }
}
