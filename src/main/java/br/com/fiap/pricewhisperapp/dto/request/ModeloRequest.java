package br.com.fiap.pricewhisperapp.dto.request;

public record ModeloRequest(
        String nome,
        String descricao,
        Long marcaId
) {
}
