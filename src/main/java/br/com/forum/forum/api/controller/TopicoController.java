package br.com.forum.forum.api.controller;

import br.com.forum.forum.api.modelo.curso.Curso;
import br.com.forum.forum.api.modelo.curso.CursoRepository;
import br.com.forum.forum.api.modelo.topico.*;
import br.com.forum.forum.api.modelo.usuario.Usuario;
import br.com.forum.forum.api.modelo.usuario.UsuarioRepository;
import br.com.forum.forum.api.modelo.validacoes.ValidadorPostMensagemIguais;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    private CadastroConsulta cadastroConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity cadastratTopico(@RequestBody @Valid DadosTopico dados, UriComponentsBuilder uriBuilder){

        var topico = cadastroConsulta.cadastrar(dados);

        var uri = uriBuilder.path("/curso/{id}").buildAndExpand(topico.topico()).toUri();

        return ResponseEntity.created(uri).body(topico);
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
//        var medico = topicoRepository.getReferenceById(id);
//        medico.excluir();
        topicoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

}
