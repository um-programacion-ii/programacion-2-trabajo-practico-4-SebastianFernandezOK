package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario buscarPorEmail(String email);

    Usuario buscarPorId(Long id);

    List<Usuario> obtenerTodos();

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);

    Usuario actualizar(Long id, Usuario usuario);
}
