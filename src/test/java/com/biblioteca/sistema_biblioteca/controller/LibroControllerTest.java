package com.biblioteca.sistema_biblioteca.controller;

import com.biblioteca.sistema_biblioteca.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class)
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Test
    void obtenerTodosDevuelve200() throws Exception {
        mockMvc.perform(get("/api/libros"))
                .andExpect(status().isOk());
    }
}
