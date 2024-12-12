package br.com.poo.poobank.repository;

import br.com.poo.poobank.domain.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    // Métodos personalizados de consulta, se necessário
}
