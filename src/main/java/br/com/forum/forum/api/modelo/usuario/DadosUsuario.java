package br.com.forum.forum.api.modelo.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
