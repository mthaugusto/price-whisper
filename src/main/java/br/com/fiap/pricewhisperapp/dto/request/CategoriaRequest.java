package br.com.fiap.pricewhisperapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoriaRequest (
        @NotBlank
        @Size(min = 1, max = 255)
        @NotNull
        String nome,
        @NotBlank
        @Size(min = 1, max = 255)
        @NotNull
        String descricao
){
}
