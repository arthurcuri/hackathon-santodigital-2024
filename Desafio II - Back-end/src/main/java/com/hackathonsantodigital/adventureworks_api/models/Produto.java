package com.hackathonsantodigital.adventureworks_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Número do produto não pode ser vazio")
    private String numeroProduto;

    private String cor;

    @NotNull(message = "Preço padrão não pode ser nulo")
    @Positive(message = "Preço padrão deve ser positivo")
    private Double precoPadrao;

    private Double precoPromo;

    private String tamanho;

    private Double peso;

    public Produto() {
    }

    public Produto(String nome, String numeroProduto, String cor, Double precoPadrao, Double precoPromo, String tamanho, Double peso) {
        this.nome = nome;
        this.numeroProduto = numeroProduto;
        this.cor = cor;
        this.precoPadrao = precoPadrao;
        this.precoPromo = precoPromo;
        this.tamanho = tamanho;
        this.peso = peso;
    }
}
