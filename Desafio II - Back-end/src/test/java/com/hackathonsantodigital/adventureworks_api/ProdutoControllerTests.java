package com.hackathonsantodigital.adventureworks_api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathonsantodigital.adventureworks_api.controllers.ProdutoController;
import com.hackathonsantodigital.adventureworks_api.models.Produto;
import com.hackathonsantodigital.adventureworks_api.services.ProdutoService;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Produto 1", "P001", "Azul", 100.0, 120.0, "M", 1.0);
        produto.setId(1L);
    }

    @Test
    public void testCreateProduto() throws Exception {
        when(produtoService.createProduto(any(Produto.class))).thenReturn(produto);

        mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Produto 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroProduto").value("P001"))
                .andDo(print());
    }

    @Test
    public void testUpdateProduto() throws Exception {
        when(produtoService.updateProduto(anyLong(), any(Produto.class))).thenReturn(produto);

        mockMvc.perform(MockMvcRequestBuilders.put("/produtos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Produto 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroProduto").value("P001"))
                .andDo(print());
    }

    @Test
    public void testGetProdutoById() throws Exception {
        when(produtoService.getProdutoById(anyLong())).thenReturn(produto);

        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Produto 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroProduto").value("P001"))
                .andDo(print());
    }

    @Test
    public void testDeleteProduto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/produtos/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(print());
    }
}
