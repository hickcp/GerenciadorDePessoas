/* package com.projetocompleto.ProjetoCompleto.bootstrap;

import com.projetocompleto.ProjetoCompleto.domain.PessoaService;
import com.projetocompleto.ProjetoCompleto.domain.model.Contato;
import com.projetocompleto.ProjetoCompleto.domain.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PessoaService ps;

    @Override
    public void run(String... args) throws Exception{
        saveData();
    }
    private void saveData(){
        Pessoa p = new Pessoa();
        Contato c = new Contato();
        p.setNome("Hick");
        p.setCpf("1234");

        c.setEmail("henrique@teste");
        c.setNome("Henrique");
        c.setTelefone("12345");

        p.getContatos().add(c);

        ps.salvarPessoa(p);
    }
}

// Fazendo post via command
*/