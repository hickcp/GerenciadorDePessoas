package com.projetocompleto.ProjetoCompleto.domain.exception;

//Classe p/ localizar e/ou exibir mensagem erro na hora do SELECT
public class EntidadeNaoEncontradaException extends NegocioException{

    private static final long serialVersionUID = 5959901370633421835L;
    public EntidadeNaoEncontradaException(String message) { //Chama o construtor pai (super)
        super(message);
    }
}
