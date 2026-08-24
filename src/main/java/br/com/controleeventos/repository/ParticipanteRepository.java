package br.com.controleeventos.repository;

import br.com.controleeventos.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável pelas operações do banco relacionadas ao Participante.
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}