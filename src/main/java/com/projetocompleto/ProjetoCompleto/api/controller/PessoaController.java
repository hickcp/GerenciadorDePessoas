package com.projetocompleto.ProjetoCompleto.api.controller;

//Endpoints

import com.projetocompleto.ProjetoCompleto.domain.PessoaService;
import com.projetocompleto.ProjetoCompleto.domain.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private PessoaService pessoaService;
    //acesso a camada de serviço
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping //retorna uma lista de pessoas
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/{id}") //retorna pessoa pelo ID
    public ResponseEntity<Pessoa> buscar(@PathVariable(name = "id") Long id){ //@PathVariable Variavel que passa lá no path. (name = "id"| diz que esse id é o parametro que vai no "/{id}"
        return ResponseEntity.ok(pessoaService.getPessoa(id)); //Esse ok() retorna um valor na tela (200 de ok)
    }
}
