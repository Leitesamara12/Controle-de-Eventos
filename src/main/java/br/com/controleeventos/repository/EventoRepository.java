package br.com.controleeventos.repository;

// Importa o Model Evento.
import br.com.controleeventos.model.Evento;

// Importa o JpaRepository.
// Ele fornece operações prontas para acessar o banco,
// como salvar, buscar, alterar e excluir.
import org.springframework.data.jpa.repository.JpaRepository;

//EventoRepository herda as funcionalidades do JpaRepository.

// JpaRepository: É a ferramenta que vem do Spring Data JPA e já possui várias operações prontas:

// save() → salvar
// findAll() → buscar todos
// findById() → buscar por ID
// deleteById() → excluir

public interface EventoRepository extends JpaRepository<Evento, Long> {

}