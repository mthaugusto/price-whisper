package br.com.fiap.pricewhisperapp.service;

import br.com.fiap.pricewhisperapp.dto.request.ModeloRequest;
import br.com.fiap.pricewhisperapp.dto.response.ModeloResponse;
import br.com.fiap.pricewhisperapp.entity.Modelo;
import br.com.fiap.pricewhisperapp.repository.MarcaRepository;
import br.com.fiap.pricewhisperapp.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService implements ServiceDTO<Modelo, ModeloRequest, ModeloResponse> {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Modelo toEntity(ModeloRequest r) {
        return Modelo.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .marca(marcaRepository.findById(r.marcaId()).orElse(null))
                .build();
    }

    @Override
    public ModeloResponse toResponse(Modelo e) {
        return ModeloResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .marcaId(e.getMarca() != null ? e.getMarca().getId() : null)
                .build();
    }

    @Override
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    @Override
    public List<Modelo> findAll(Example<Modelo> example) {
        return modeloRepository.findAll(example);
    }

    @Override
    public Modelo findById(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    @Override
    public Modelo save(Modelo e) {
        return modeloRepository.save(e);
    }
}
