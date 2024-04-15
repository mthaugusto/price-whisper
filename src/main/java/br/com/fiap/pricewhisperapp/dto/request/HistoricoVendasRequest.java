package br.com.fiap.pricewhisperapp.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HistoricoVendasRequest(
        Long produtoId,
        LocalDate dataVenda,
        BigDecimal precoVenda,
        Integer quantidadeVendida
) {
}
