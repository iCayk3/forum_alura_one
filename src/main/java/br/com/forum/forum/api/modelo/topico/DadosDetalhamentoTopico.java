package br.com.forum.forum.api.modelo.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(String topico, String mensagem, LocalDateTime data , StatusTopico status, String autor, String curso) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor().getNome(), topico.getCurso().getNome());
    }
}

