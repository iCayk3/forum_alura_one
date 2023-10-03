package br.com.forum.forum.api.modelo.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem){
}
