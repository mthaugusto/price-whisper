package br.com.fiap.pricewhisperapp.service;

import br.com.fiap.pricewhisperapp.dto.request.CategoriaRequest;
import br.com.fiap.pricewhisperapp.dto.response.CategoriaResponse;
import br.com.fiap.pricewhisperapp.entity.Categoria;
import br.com.fiap.pricewhisperapp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ServiceDTO<Categoria, CategoriaRequest, CategoriaResponse> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria toEntity(CategoriaRequest r) {
        return Categoria.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .build();
    }

    @Override
    public CategoriaResponse toResponse(Categoria e) {
        return CategoriaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .build();
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Categoria> findAll(Example<Categoria> example) {
        return categoriaRepository.findAll(example);
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria e) {
        return categoriaRepository.save(e);
    }
}
