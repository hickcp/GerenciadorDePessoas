package com.projetocompleto.ProjetoCompleto.domain.exception;
//Classe pai exception
public class NegocioException extends RuntimeException{ //Exceção personalizada
    private static final long serialVersionUID = 370988225246302742L;

    public NegocioException(String message){ //Construtor
        super(message);
    }
}
