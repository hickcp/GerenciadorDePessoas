package com.projetocompleto.ProjetoCompleto.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity //Diz ao Banco de Dados que é um entidade (valor de uma tabela)
public class Pessoa {
    @Id //Diz ao BD que é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera automaticamente o valor do ID ( Identity = O próprio BD cria o valor)
    private Long id;

    @NotBlank
    @Column(nullable = false, name = "nome", length = 100) // Indica ao BD que é uma coluna, colocando o nome e o nº max de caracteres.
    private String nome;

    @NotBlank
    @Column(nullable = false, name = "cpf", length = 20)
    private String cpf;

    @Valid
    @JsonIgnoreProperties("pessoa") //quando encontrar pessoa não faça nada (evita looping)
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true) //Indica ao BD que é um (pessoa) para muitos (contatos)
    //Indica que é mapeado pela classe pessoa. Quando deleta tudo, deleta tudo mesmo.
    private List<Contato> contatos = new ArrayList<>(); //Cria uma lista de contatos.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
