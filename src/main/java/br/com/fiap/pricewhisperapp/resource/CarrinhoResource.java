package br.com.fiap.pricewhisperapp.resource;


import br.com.fiap.pricewhisperapp.dto.request.CarrinhoRequest;
import br.com.fiap.pricewhisperapp.dto.response.CarrinhoResponse;
import br.com.fiap.pricewhisperapp.entity.Carrinho;
import br.com.fiap.pricewhisperapp.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService service;

    @GetMapping
    public ResponseEntity<List<CarrinhoResponse>> findAll() {
        List<CarrinhoResponse> carrinhos = service.findAll().stream()
                .map(service::toResponse)
                .toList();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponse> findById(@PathVariable Long id) {
        Carrinho carrinho = service.findById(id);
        if (carrinho == null) {
            return ResponseEntity.notFound().build();
        }
        CarrinhoResponse response = service.toResponse(carrinho);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CarrinhoResponse> save(@RequestBody CarrinhoRequest r) {
        Carrinho entity = service.toEntity(r);
        Carrinho saved = service.save(entity);
        CarrinhoResponse response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
