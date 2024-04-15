package br.com.fiap.pricewhisperapp.resource;

import br.com.fiap.pricewhisperapp.dto.request.HistoricoVendasRequest;
import br.com.fiap.pricewhisperapp.dto.response.HistoricoVendasResponse;
import br.com.fiap.pricewhisperapp.entity.HistoricoVendas;
import br.com.fiap.pricewhisperapp.service.HistoricoVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/historicos-vendas")
public class HistoricoVendasResource {

    @Autowired
    private HistoricoVendasService service;

    @GetMapping
    public ResponseEntity<List<HistoricoVendasResponse>> findAll() {
        List<HistoricoVendasResponse> historicos = service.findAll().stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(historicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoVendasResponse> findById(@PathVariable Long id) {
        HistoricoVendas historico = service.findById(id);
        HistoricoVendasResponse response = service.toResponse(historico);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<HistoricoVendasResponse> save(@RequestBody HistoricoVendasRequest r) {
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
