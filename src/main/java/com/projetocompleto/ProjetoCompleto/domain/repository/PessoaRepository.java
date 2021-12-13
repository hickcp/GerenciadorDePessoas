package com.projetocompleto.ProjetoCompleto.domain.repository;

import com.projetocompleto.ProjetoCompleto.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long>{


}
