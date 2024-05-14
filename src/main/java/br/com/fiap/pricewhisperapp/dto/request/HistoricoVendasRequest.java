package br.com.fiap.pricewhisperapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record HistoricoVendasRequest(
        @NotNull
        @NotBlank
        Long produtoId,
        @NotNull
        @NotBlank
        LocalDate dataVenda,
        @NotNull
        @NotBlank
        BigDecimal precoVenda,
        @NotNull
        @Positive
        Integer quantidadeVendida
) {
}
