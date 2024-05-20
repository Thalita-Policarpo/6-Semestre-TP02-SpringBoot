package br.com.edu.infnet.cadastroprodutos.controller;

import br.com.edu.infnet.cadastroprodutos.domain.Produto;
import br.com.edu.infnet.cadastroprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Produto produto) {
        try{
            Produto _produto = produtoService.save(produto);
            return new ResponseEntity<>(_produto, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex){
            return new ResponseEntity<>("Erro ao criar produto. Tente novamente!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        try {
            List<Produto> produtos = produtoService.findAll();
            if (produtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Optional<Produto> produtoData = produtoService.findById(id);

        if (produtoData.isPresent()) {
            return new ResponseEntity<>(produtoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> produtoData = produtoService.findById(id);

        if (produtoData.isPresent()) {
            Produto _produto = produtoData.get();
            _produto.setNome(produto.getNome());
            _produto.setDescricao(produto.getDescricao());
            _produto.setPreco(produto.getPreco());
            return new ResponseEntity<>(produtoService.save(_produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            produtoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
