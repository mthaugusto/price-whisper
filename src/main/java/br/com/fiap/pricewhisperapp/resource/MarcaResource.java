package br.com.fiap.pricewhisperapp.resource;

import br.com.fiap.pricewhisperapp.dto.request.MarcaRequest;
import br.com.fiap.pricewhisperapp.dto.response.MarcaResponse;
import br.com.fiap.pricewhisperapp.entity.Marca;
import br.com.fiap.pricewhisperapp.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaResource {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<List<MarcaResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome
    ) {
        Marca marca = Marca.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Marca> example = Example.of(marca, matcher);

        List<Marca> encontradas = service.findAll(example);

        List<MarcaResponse> respostas = encontradas.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaResponse> findById(@PathVariable Long id) {
        Marca marca = service.findById(id);
        MarcaResponse response = service.toResponse(marca);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<MarcaResponse> save(@RequestBody MarcaRequest r) {
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
