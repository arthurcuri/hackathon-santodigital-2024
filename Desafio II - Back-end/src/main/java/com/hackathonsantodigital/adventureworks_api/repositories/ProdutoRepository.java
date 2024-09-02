package com.hackathonsantodigital.adventureworks_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonsantodigital.adventureworks_api.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
