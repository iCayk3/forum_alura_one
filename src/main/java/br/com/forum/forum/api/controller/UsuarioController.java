package br.com.forum.forum.api.controller;

import br.com.forum.forum.api.modelo.curso.DadosDetalhamentoCurso;
import br.com.forum.forum.api.modelo.usuario.DadosDetalhamentoUsuario;
import br.com.forum.forum.api.modelo.usuario.DadosUsuario;
import br.com.forum.forum.api.modelo.usuario.Usuario;
import br.com.forum.forum.api.modelo.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosUsuario dados, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dados.nome(), dados.email(), encoder.encode(dados.senha()));
        System.out.println(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));

    }
}
