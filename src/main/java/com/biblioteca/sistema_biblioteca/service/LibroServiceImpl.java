package com.biblioteca.sistema_biblioteca.service;

import java.util.List;

import com.biblioteca.sistema_biblioteca.model.Libro;
import com.biblioteca.sistema_biblioteca.repository.LibroRepository;

import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado por ISBN: " + isbn));
    }

    @Override
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado por ID: " + id));
    }

    @Override
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado para actualizar con ID: " + id);
        }
        libro.setId(id);
        return libroRepository.save(libro);
    }
}
