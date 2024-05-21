package br.com.fiap.pricewhisperapp.resource;

import br.com.fiap.pricewhisperapp.dto.request.ModeloRequest;
import br.com.fiap.pricewhisperapp.dto.response.ModeloResponse;
import br.com.fiap.pricewhisperapp.entity.Modelo;
import br.com.fiap.pricewhisperapp.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloResource {

    @Autowired
    private ModeloService service;

    @GetMapping
    public ResponseEntity<List<ModeloResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome
    ) {
        Modelo modelo = Modelo.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Modelo> example = Example.of(modelo, matcher);

        List<Modelo> encontrados = service.findAll(example);

        List<ModeloResponse> respostas = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponse> findById(@PathVariable Long id) {
        Modelo modelo = service.findById(id);
        ModeloResponse response = service.toResponse(modelo);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ModeloResponse> save(@RequestBody ModeloRequest r) {
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
