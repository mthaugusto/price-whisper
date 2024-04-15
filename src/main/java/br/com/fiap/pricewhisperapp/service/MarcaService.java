package br.com.fiap.pricewhisperapp.service;

import br.com.fiap.pricewhisperapp.dto.request.MarcaRequest;
import br.com.fiap.pricewhisperapp.dto.response.MarcaResponse;
import br.com.fiap.pricewhisperapp.entity.Marca;
import br.com.fiap.pricewhisperapp.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService implements ServiceDTO<Marca, MarcaRequest, MarcaResponse> {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca toEntity(MarcaRequest r) {
        return Marca.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .build();
    }

    @Override
    public MarcaResponse toResponse(Marca e) {
        return MarcaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .build();
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public List<Marca> findAll(Example<Marca> example) {
        return marcaRepository.findAll(example);
    }

    @Override
    public Marca findById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public Marca save(Marca e) {
        return marcaRepository.save(e);
    }
}
