package br.com.forum.forum.api.modelo.usuario;

import br.com.forum.forum.api.modelo.curso.DadosDetalhamentoCurso;

public record DadosDetalhamentoUsuario(Long id, String nome, String email) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
