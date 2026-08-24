package br.com.controleeventos.service;

import br.com.controleeventos.model.Participante;
import br.com.controleeventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service responsável pelas regras relacionadas aos participantes.
@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    // Recebe o Repository que será usado para acessar o banco.
    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    // Busca todos os participantes cadastrados.
    public List<Participante> listar() {
        return participanteRepository.findAll();
    }

    // Busca um participante pelo ID.
    public Participante buscarPorId(Long id) {
        return participanteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Participante não encontrado."));
    }

    // Cadastra ou atualiza um participante.
    public Participante salvar(Participante participante) {
        return participanteRepository.save(participante);
    }

    // Exclui um participante pelo ID.
    public void excluir(Long id) {
        participanteRepository.deleteById(id);
    }
}