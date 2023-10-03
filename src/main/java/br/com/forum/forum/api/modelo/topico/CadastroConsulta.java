package br.com.forum.forum.api.modelo.topico;

import br.com.forum.forum.api.modelo.curso.Curso;
import br.com.forum.forum.api.modelo.curso.CursoRepository;
import br.com.forum.forum.api.modelo.usuario.Usuario;
import br.com.forum.forum.api.modelo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
public class CadastroConsulta {


    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public DadosDetalhamentoTopico cadastrar(DadosTopico dados){

        validaCadastro(dados);

        var curso = cursoRepository.findById(1L);
        var usuario = usuarioRepository.findById(1L);

        Curso curso1 = new Curso(curso.get().getId(), curso.get().getNome(), curso.get().getCategoria());

        Usuario usuario1 = new Usuario(usuario.get().getId(),
                usuario.get().getNome(),
                usuario.get().getEmail());

        var topico = new Topico(dados.titulo(), dados.mensagem(), usuario1, curso1);

        //topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }


    private void validaCadastro(DadosTopico topico){
       var topicoBD = topicoRepository.existsByTopico(topico.titulo());

        System.out.println(topico.mensagem().getClass());
        System.out.println(topicoBD.getMensagem().getClass());

        System.out.println(topicoBD);
           if(topico.mensagem().contains(topicoBD.getMensagem())){
               throw new RuntimeException("Topico ja cadastrado");
           }
       }
    }


