package com.biblioteca.sistema_biblioteca.service;

import com.biblioteca.sistema_biblioteca.model.Prestamo;

import java.util.List;

public interface PrestamoService {
    Prestamo buscarPorId(Long id);

    List<Prestamo> obtenerTodos();

    Prestamo guardar(Prestamo prestamo);

    void eliminar(Long id);

    Prestamo actualizar(Long id, Prestamo prestamo);
}
