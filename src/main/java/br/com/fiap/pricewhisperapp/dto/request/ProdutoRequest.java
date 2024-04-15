package br.com.fiap.pricewhisperapp.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        String descricao,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        BigDecimal precoMinimo,
        Integer estoque,
        Long marcaId,
        Long modeloId,
        Long categoriaId
) {
}
