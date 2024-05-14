package br.com.fiap.pricewhisperapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ModeloRequest(
        @NotBlank
        @NotNull
        @Size(min = 1, max = 255)
        String nome,
        @NotBlank
        @NotNull
        @Size(min = 1, max = 255)
        String descricao,
        @Positive
        @NotNull
        Long marcaId
) {
}
