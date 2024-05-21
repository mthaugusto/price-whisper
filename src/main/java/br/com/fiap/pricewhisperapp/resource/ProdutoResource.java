package br.com.fiap.pricewhisperapp.resource;


import br.com.fiap.pricewhisperapp.dto.request.ProdutoRequest;
import br.com.fiap.pricewhisperapp.dto.response.ProdutoResponse;
import br.com.fiap.pricewhisperapp.entity.Produto;
import br.com.fiap.pricewhisperapp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome
    ) {
        Produto produto = Produto.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Produto> example = Example.of(produto, matcher);

        List<Produto> encontrados = service.findAll(example);

        List<ProdutoResponse> respostas = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        Produto produto = service.findById(id);
        ProdutoResponse response = service.toResponse(produto);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ProdutoResponse> save(@RequestBody ProdutoRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
