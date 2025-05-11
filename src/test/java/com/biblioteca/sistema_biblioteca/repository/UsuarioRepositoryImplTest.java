package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.EstadoUsuario;
import com.biblioteca.sistema_biblioteca.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryImplTest {

    private UsuarioRepositoryImpl usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository = new UsuarioRepositoryImpl();
    }

    @Test
    void guardarYBuscarPorId_funcionaCorrectamente() {
        Usuario usuario = new Usuario(null, "Pedro", "pedro@mail.com", EstadoUsuario.ACTIVO);
        Usuario guardado = usuarioRepository.save(usuario);

        Optional<Usuario> resultado = usuarioRepository.findById(guardado.getId());

        assertTrue(resultado.isPresent());
        assertEquals("Pedro", resultado.get().getNombre());
    }

    @Test
    void eliminarPorId_quitaElUsuario() {
        Usuario usuario = new Usuario(null, "Lucía", "lucia@mail.com", EstadoUsuario.INACTIVO);
        Usuario guardado = usuarioRepository.save(usuario);

        usuarioRepository.deleteById(guardado.getId());

        Optional<Usuario> resultado = usuarioRepository.findById(guardado.getId());
        assertFalse(resultado.isPresent());
    }

    @Test
    void existePorId_devuelveTrueSiExiste() {
        Usuario usuario = new Usuario(null, "Juan", "juan@mail.com", EstadoUsuario.ACTIVO);
        Usuario guardado = usuarioRepository.save(usuario);

        assertTrue(usuarioRepository.existsById(guardado.getId()));
    }
}
