package br.com.controleeventos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// @Entity informa ao JPA que esta classe representa uma tabela no banco.
@Entity
public class Inscricao {

    // @Id identifica cada inscrição.
    @Id

    // O banco gera o ID automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitas inscrições podem pertencer ao mesmo evento.
    @ManyToOne
    private Evento evento;

    // Muitas inscrições podem pertencer ao mesmo participante.
    @ManyToOne
    private Participante participante;

    // Construtor vazio usado pelo JPA.
    public Inscricao() {
    }

    // Retorna o ID da inscrição.
    public Long getId() {
        return id;
    }

    // Altera o ID da inscrição.
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o evento relacionado à inscrição.
    public Evento getEvento() {
        return evento;
    }

    // Altera o evento relacionado à inscrição.
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Retorna o participante relacionado à inscrição.
    public Participante getParticipante() {
        return participante;
    }

    // Altera o participante relacionado à inscrição.
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}