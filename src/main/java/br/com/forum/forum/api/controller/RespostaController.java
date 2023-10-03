package br.com.forum.forum.api.controller;

import br.com.forum.forum.api.modelo.resposta.DadosResposta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resposta")
public class RespostaController {

    public ResponseEntity cadastrarResposta(@RequestBody DadosResposta dados){

        return ResponseEntity.ok().build();
    }
}
