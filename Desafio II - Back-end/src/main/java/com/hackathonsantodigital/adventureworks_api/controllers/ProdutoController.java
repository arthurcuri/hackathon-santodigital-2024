    package com.hackathonsantodigital.adventureworks_api.controllers;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.hackathonsantodigital.adventureworks_api.models.Produto;
    import com.hackathonsantodigital.adventureworks_api.services.ProdutoService;

    import jakarta.validation.Valid;

    @RestController
    @RequestMapping("/produtos")
    public class ProdutoController {

        @Autowired
        private ProdutoService produtoService;

        @PostMapping
        public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
            Produto createdProduto = produtoService.createProduto(produto);
            return new ResponseEntity<>(createdProduto, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
            Produto updatedProduto = produtoService.updateProduto(id, produto);
            return new ResponseEntity<>(updatedProduto, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<Page<Produto>> getAllProdutos(Pageable pageable) {
            Page<Produto> produtos = produtoService.getAllProdutos(pageable);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
            Produto produto = produtoService.getProdutoById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
            produtoService.deleteProduto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
