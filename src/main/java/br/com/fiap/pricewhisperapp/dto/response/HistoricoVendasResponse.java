package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record HistoricoVendasResponse(
        Long id,
        Long produtoId,
        LocalDate dataVenda,
        BigDecimal precoVenda,
        Integer quantidadeVendida
) {
}
