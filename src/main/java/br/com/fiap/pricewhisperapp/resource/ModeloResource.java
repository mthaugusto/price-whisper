package br.com.fiap.pricewhisperapp.resource;

import br.com.fiap.pricewhisperapp.dto.request.ModeloRequest;
import br.com.fiap.pricewhisperapp.dto.response.ModeloResponse;
import br.com.fiap.pricewhisperapp.entity.Modelo;
import br.com.fiap.pricewhisperapp.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ModeloResponse>> findAll() {
        List<ModeloResponse> modelos = service.findAll().stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(modelos);
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
