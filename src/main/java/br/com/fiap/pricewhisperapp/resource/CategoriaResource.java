package br.com.fiap.pricewhisperapp.resource;

import br.com.fiap.pricewhisperapp.dto.request.CategoriaRequest;
import br.com.fiap.pricewhisperapp.dto.response.CategoriaResponse;
import br.com.fiap.pricewhisperapp.entity.Categoria;
import br.com.fiap.pricewhisperapp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll(
            @RequestParam(required = false) String nome
    ) {

        Categoria categoria = Categoria.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Categoria> example = Example.of(categoria, matcher);

        List<Categoria> encontradas = service.findAll(example);

        List<CategoriaResponse> respostas = encontradas.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        Categoria categoria = service.findById(id);
        CategoriaResponse response = service.toResponse(categoria);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CategoriaResponse> save(@RequestBody CategoriaRequest r) {
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
