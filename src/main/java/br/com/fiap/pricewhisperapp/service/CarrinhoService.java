package br.com.fiap.pricewhisperapp.service;

import br.com.fiap.pricewhisperapp.entity.Carrinho;
import br.com.fiap.pricewhisperapp.dto.request.CarrinhoRequest;
import br.com.fiap.pricewhisperapp.dto.response.CarrinhoResponse;
import br.com.fiap.pricewhisperapp.repository.CarrinhoRepository;
import br.com.fiap.pricewhisperapp.repository.HistoricoVendasRepository;
import br.com.fiap.pricewhisperapp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService implements ServiceDTO<Carrinho, CarrinhoRequest, CarrinhoResponse> {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private HistoricoVendasRepository vendasRepository;

    @Override
    public Carrinho toEntity(CarrinhoRequest r) {
        return Carrinho.builder()
                .quantidadeProdutos(r.quantidadeProdutos())
                .subTotal(r.subTotal())
                .historicoVenda(vendasRepository.findById(r.historicoVendaId()).orElse(null))
                .produto(produtoRepository.findById(r.produtoId()).orElse(null))
                .build();
    }

    @Override
    public CarrinhoResponse toResponse(Carrinho e) {
        return CarrinhoResponse.builder()
                .id(e.getId())
                .quantidadeProdutos(e.getQuantidadeProdutos())
                .subTotal(e.getSubTotal())
                .produtoId(e.getProduto() != null ? e.getProduto().getId() : null)
                .historicoVendaId(e.getHistoricoVenda() != null ? e.getHistoricoVenda().getId() : null)
                .build();
    }

    @Override
    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    @Override
    public List<Carrinho> findAll(Example<Carrinho> example) {
        return carrinhoRepository.findAll(example);
    }

    @Override
    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }

    @Override
    public Carrinho save(Carrinho e) {
        return carrinhoRepository.save(e);
    }
}
