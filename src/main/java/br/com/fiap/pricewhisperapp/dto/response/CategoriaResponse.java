package br.com.fiap.pricewhisperapp.dto.response;

import lombok.Builder;

@Builder
public record CategoriaResponse(
        Long id,
        String nome,
        String descricao

) {
}
