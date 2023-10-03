package br.com.forum.forum.api.controller;

import br.com.forum.forum.api.modelo.curso.Curso;
import br.com.forum.forum.api.modelo.curso.CursoRepository;
import br.com.forum.forum.api.modelo.curso.DadosCurso;
import br.com.forum.forum.api.modelo.curso.DadosDetalhamentoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCurso(@RequestBody @Valid DadosCurso dados, UriComponentsBuilder uriBuilder){
        var curso = new Curso(dados.nome(), dados.categoria());
        repository.save(curso);

        var uri = uriBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }


}
