package com.projetocompleto.ProjetoCompleto.api.controller;

//Endpoints

import com.projetocompleto.ProjetoCompleto.domain.PessoaService;
import com.projetocompleto.ProjetoCompleto.domain.event.RecursoCriadoEvent;
import com.projetocompleto.ProjetoCompleto.domain.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private PessoaService pessoaService;
    //acesso a camada de serviço

    private ApplicationEventPublisher publisher;

    @Autowired
    public PessoaController(PessoaService pessoaService, ApplicationEventPublisher publisher) {
        this.pessoaService = pessoaService;
        this.publisher = publisher;
    }

    @GetMapping //retorna uma lista de pessoas
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/{id}") //retorna pessoa pelo ID
    public ResponseEntity<Pessoa> buscar(@PathVariable(name = "id") Long id){ //@PathVariable Variavel que passa lá no path. (name = "id"| diz que esse id é o parametro que vai no "/{id}"
        return ResponseEntity.ok(pessoaService.getPessoa(id)); //Esse ok() retorna um valor na tela (200 de ok)
    }

    @PostMapping //grava no banco de dados
    public ResponseEntity<Pessoa> salvar(@Validated @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa p = pessoaService.salvarPessoa(pessoa); // grava uma pessoa no BD
        publisher.publishEvent(new RecursoCriadoEvent(this, response, p.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(p); // Se der tudo certo retorna uma mensagem de CREATED;
    }

    @PutMapping("/{id}") //edita no BD
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa){ //@PathVariable Variavel que passa lá no path. (name = "id"| diz que esse id é o parametro que vai no "/{id}"
        return ResponseEntity.ok(pessoaService.atualizarPessoa(id, pessoa));

    }

    @DeleteMapping("/{id}") //Deleta no BD
    @ResponseStatus(HttpStatus.NO_CONTENT) //retorno sem conteúdo ///@PathVariable Variavel que passa lá no path. (name = "id"| diz que esse id é o parametro que vai no "/{id}"
    public void delete(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
    }
}
