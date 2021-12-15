package com.projetocompleto.ProjetoCompleto.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity //Entidade do BD
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, name = "nome", length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, name = "telefone", length = 20)
    private String telefone;

    @NotBlank
    @Column(nullable = false, name = "email", length = 60)
    private String email;


    @ManyToOne // Muitos contatos para uma pessoa
    @JoinColumn(name = "id_pessoa") //Chave secundária
    private Pessoa pessoa;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
