package br.com.fiap.pricewhisperapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank
        @Size(min = 1, max = 255)
        String nome,
        @NotBlank
        @Size(min = 1, max = 255)
        String descricao,
        @NotNull
        BigDecimal precoCusto,
        @NotNull
        BigDecimal precoVenda,
        @NotNull
        BigDecimal precoMinimo,
        @Positive
        @NotNull
        Integer estoque,
        @Positive
        @NotNull
        Long modeloId,
        @Positive
        @NotNull
        Long categoriaId
) {
}
