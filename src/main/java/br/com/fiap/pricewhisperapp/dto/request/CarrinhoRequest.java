package br.com.fiap.pricewhisperapp.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CarrinhoRequest(
        @Positive
        @NotNull
        int quantidadeProdutos,
        @Positive
        @NotNull
        Double subTotal,
        @Positive
        @NotNull
        Long produtoId,
        @Positive
        @NotNull
        Long historicoVendaId
) {
}
