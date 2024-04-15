package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

@Builder
public record ModeloResponse(
        Long id,
        String nome,
        String descricao,
        Long marcaId
) {
}
