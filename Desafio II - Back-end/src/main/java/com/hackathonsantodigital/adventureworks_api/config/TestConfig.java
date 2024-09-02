package com.hackathonsantodigital.adventureworks_api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hackathonsantodigital.adventureworks_api.models.Produto;
import com.hackathonsantodigital.adventureworks_api.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        Produto p1 = new Produto("Produto 1", "P001", "Azul", 100.0, 120.0, "M", 1.0);
        Produto p2 = new Produto("Produto 2", "P002", "Vermelho", 200.0, 220.0, "G", 2.0);
        Produto p3 = new Produto("Produto 3", "P003", "Verde", 300.0, 320.0, "P", 3.0);
        Produto p4 = new Produto("Produto 4", "P004", "Amarelo", 400.0, 420.0, "GG", 4.0);
        Produto p5 = new Produto("Produto 5", "P005", "Preto", 500.0, 520.0, "XG", 5.0);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
