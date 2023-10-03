package br.com.forum.forum.api.modelo.validacoes;

import br.com.forum.forum.api.modelo.topico.DadosTopico;
import br.com.forum.forum.api.modelo.topico.StatusTopico;
import br.com.forum.forum.api.modelo.topico.Topico;
import br.com.forum.forum.api.modelo.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidadorPostMensagemIguais {

    @Autowired
    TopicoRepository repository;

    public void checaSeJaExistePost(Topico topico){
        List<Topico> topicoBD = repository.findAll();
        System.out.println(topicoBD);
        for(Topico item : topicoBD){
            if(item.getTitulo() == topico.getTitulo() && item.getMensagem() == topico.getMensagem()){
                new RuntimeException("Titulo e mensagem ja cadastrada");
            }
        }
    }
}
