package br.com.fiap.pricewhisperapp.service;
import br.com.fiap.pricewhisperapp.dto.request.ProdutoRequest;
import br.com.fiap.pricewhisperapp.dto.response.ProdutoResponse;
import br.com.fiap.pricewhisperapp.entity.Produto;
import br.com.fiap.pricewhisperapp.repository.CategoriaRepository;
import br.com.fiap.pricewhisperapp.repository.MarcaRepository;
import br.com.fiap.pricewhisperapp.repository.ModeloRepository;
import br.com.fiap.pricewhisperapp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse>{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Produto toEntity(ProdutoRequest r) {
        return Produto.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .precoCusto(r.precoCusto())
                .precoVenda(r.precoVenda())
                .precoMinimo(r.precoMinimo())
                .estoque(r.estoque())
                .marca(marcaRepository.findById(r.marcaId()).orElse(null))
                .modelo(modeloRepository.findById(r.modeloId()).orElse(null))
                .categoria(categoriaRepository.findById(r.categoriaId()).orElse(null))
                .build();

    }

    @Override
    public ProdutoResponse toResponse(Produto e) {
        return ProdutoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .precoCusto(e.getPrecoCusto())
                .precoVenda(e.getPrecoVenda())
                .precoMinimo(e.getPrecoMinimo())
                .estoque(e.getEstoque())
                .marcaId(e.getMarca() != null ? e.getMarca().getId() : null)
                .modeloId(e.getModelo() != null ? e.getModelo().getId() : null)
                .categoriaId(e.getCategoria() != null ? e.getCategoria().getId() : null)
                .build();
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> findAll(Example<Produto> example) {
        return produtoRepository.findAll(example);
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto save(Produto e) {
        return produtoRepository.save(e);
    }
}
