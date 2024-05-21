package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

@Builder
public record CarrinhoResponse(
    Long id,
    int quantidadeProdutos,
    Double subTotal,
    Long produtoId,
    Long historicoVendaId
) {
}
