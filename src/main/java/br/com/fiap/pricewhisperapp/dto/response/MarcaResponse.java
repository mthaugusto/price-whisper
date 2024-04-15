package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

@Builder
public record MarcaResponse(
        Long id,
        String nome,
        String descricao
) {
}
