package br.com.poo.poobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.poo.poobank.domain.Transacao;

@Repository
public interface TransacaoRepository 
    extends JpaRepository<Transacao, Integer>{
    
}