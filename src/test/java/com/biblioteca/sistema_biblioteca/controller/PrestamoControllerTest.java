package com.biblioteca.sistema_biblioteca.controller;

import com.biblioteca.sistema_biblioteca.service.PrestamoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrestamoController.class)
class PrestamoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrestamoService prestamoService;

    @Test
    void obtenerTodosDevuelve200() throws Exception {
        mockMvc.perform(get("/api/prestamos"))
                .andExpect(status().isOk());
    }
}
