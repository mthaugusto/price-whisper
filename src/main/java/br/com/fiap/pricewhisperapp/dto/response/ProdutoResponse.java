package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        BigDecimal precoMinimo,
        Integer estoque,
        Long modeloId,
        Long categoriaId
) {
}
