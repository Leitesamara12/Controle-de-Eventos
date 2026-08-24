package br.com.controleeventos.repository;

import br.com.controleeventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável pelas operações do banco relacionadas à Inscrição.
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

}