package br.com.controleeventos.service;

import br.com.controleeventos.model.Evento;
import br.com.controleeventos.model.Inscricao;
import br.com.controleeventos.model.Participante;
import br.com.controleeventos.repository.EventoRepository;
import br.com.controleeventos.repository.InscricaoRepository;
import br.com.controleeventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

// Service responsável pelas regras das inscrições.
@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;
    private final ParticipanteRepository participanteRepository;

    public InscricaoService(
            InscricaoRepository inscricaoRepository,
            EventoRepository eventoRepository,
            ParticipanteRepository participanteRepository) {

        this.inscricaoRepository = inscricaoRepository;
        this.eventoRepository = eventoRepository;
        this.participanteRepository = participanteRepository;
    }

    // Realiza uma nova inscrição.
    public Inscricao inscrever(Long eventoId, Long participanteId) {

        // Busca o evento pelo ID.
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado."));

        // Busca o participante pelo ID.
        Participante participante = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new IllegalArgumentException("Participante não encontrado."));

        // Verifica se o evento já atingiu sua capacidade máxima.
        if (evento.getInscricoes().size() >= evento.getCapacidadeMaxima()) {
            throw new IllegalArgumentException("Evento lotado.");
        }

        // Verifica se o participante já está inscrito nesse evento.
        boolean jaInscrito = evento.getInscricoes()
                .stream()
                .anyMatch(inscricao ->
                        inscricao.getParticipante().getId().equals(participanteId));

        if (jaInscrito) {
            throw new IllegalArgumentException("Participante já inscrito.");
        }

        // Cria uma nova inscrição.
        Inscricao inscricao = new Inscricao();

        // Relaciona a inscrição com o evento.
        inscricao.setEvento(evento);

        // Relaciona a inscrição com o participante.
        inscricao.setParticipante(participante);

        // Salva a inscrição no banco.
        return inscricaoRepository.save(inscricao);
    }
}