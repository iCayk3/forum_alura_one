package br.com.forum.forum.api.modelo.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
