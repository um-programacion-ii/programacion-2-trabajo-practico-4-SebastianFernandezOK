package com.biblioteca.sistema_biblioteca.repository;

import com.biblioteca.sistema_biblioteca.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroRepository {
    Libro save(Libro libro);

    Optional<Libro> findById(Long id);

    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
