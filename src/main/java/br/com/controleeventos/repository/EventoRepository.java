package br.com.controleeventos.repository;

import br.com.controleeventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável pelas operações do banco relacionadas ao Evento.
public interface EventoRepository extends JpaRepository<Evento, Long> {

}