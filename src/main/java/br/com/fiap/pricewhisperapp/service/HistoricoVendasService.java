package br.com.fiap.pricewhisperapp.service;

import br.com.fiap.pricewhisperapp.dto.request.HistoricoVendasRequest;
import br.com.fiap.pricewhisperapp.dto.response.HistoricoVendasResponse;
import br.com.fiap.pricewhisperapp.entity.HistoricoVendas;
import br.com.fiap.pricewhisperapp.repository.HistoricoVendasRepository;
import br.com.fiap.pricewhisperapp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoVendasService implements ServiceDTO<HistoricoVendas, HistoricoVendasRequest, HistoricoVendasResponse> {

    @Autowired
    private HistoricoVendasRepository historicoVendasRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public HistoricoVendas toEntity(HistoricoVendasRequest r) {
        return HistoricoVendas.builder()
                .produto(produtoRepository.findById(r.produtoId()).orElse(null))
                .dataVenda(r.dataVenda())
                .precoVenda(r.precoVenda())
                .quantidadeVendida(r.quantidadeVendida())
                .build();
    }

    @Override
    public HistoricoVendasResponse toResponse(HistoricoVendas e) {
        return HistoricoVendasResponse.builder()
                .id(e.getId())
                .produtoId(e.getProduto() != null ? e.getProduto().getId() : null)
                .dataVenda(e.getDataVenda())
                .precoVenda(e.getPrecoVenda())
                .quantidadeVendida(e.getQuantidadeVendida())
                .build();
    }

    @Override
    public List<HistoricoVendas> findAll() {
        return historicoVendasRepository.findAll();
    }

    @Override
    public List<HistoricoVendas> findAll(Example<HistoricoVendas> example) {
        return historicoVendasRepository.findAll(example);
    }

    @Override
    public HistoricoVendas findById(Long id) {
        return historicoVendasRepository.findById(id).orElse(null);
    }

    @Override
    public HistoricoVendas save(HistoricoVendas e) {
        return historicoVendasRepository.save(e);
    }
}
