package com.projetocompleto.ProjetoCompleto.domain;

import com.projetocompleto.ProjetoCompleto.domain.exception.EntidadeNaoEncontradaException;
import com.projetocompleto.ProjetoCompleto.domain.model.Pessoa;
import com.projetocompleto.ProjetoCompleto.domain.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Notação p/ mostrar p Spring que é um serviço/regra de negócio. P/ trabalhar c/ injeção de dependencia
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired //Injeção de dependência |
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    //GET
    public List<Pessoa> listar(){ //Lista de pessoas
        return pessoaRepository.findAll(); // Traz todas pessoas do BD {SELECT * FROM PESSOA}

    }
    //GET
    public Pessoa getPessoa(long id){ // Faz um SELECT pelo getPessoa id
        return findOrFail(id);
    }

    //POST (GRAVAR NO BD)
    public Pessoa salvarPessoa(Pessoa p){ //Salvar pessoa do Tipo pessoa, recebe como parametro Pessoa p
        p.getContatos().forEach(c -> c.setPessoa(p)); // Para cada contato insere uma pessoa
        return pessoaRepository.save(p); //salva
    }

    //PUT
    public Pessoa atualizarPessoa(long id, Pessoa p){
        Pessoa pessoaSalva = findOrFail(id);

        pessoaSalva.getContatos().clear(); //limpa todos os contatos

        pessoaSalva.getContatos().addAll(p.getContatos()); //salva todos os contatos que vieram na tela

        BeanUtils.copyProperties(p, pessoaSalva, "id", "contatos"); //Grava

        return pessoaRepository.save(pessoaSalva);
    }

    //DELETE
    public void deletarPessoa(Long id){
        Pessoa p = findOrFail(id); //Encontra a pessoa pelo Id
        pessoaRepository.delete(p);//Delete a pessoa
    }
    private Pessoa findOrFail(Long id){
        return pessoaRepository.findById(id). //Exceção personalizada
                orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não localizada")); //Função que retorna a pessoa ou um erro (EntidadeNaoEncontradaException)
    }

}
