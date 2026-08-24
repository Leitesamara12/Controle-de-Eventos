package br.com.controleeventos.service;

import br.com.controleeventos.model.Evento;
import br.com.controleeventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service responsável pelas regras relacionadas aos eventos.
@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    // Recebe o Repository que será usado para acessar o banco.
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Busca todos os eventos cadastrados no banco.
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    // Busca um evento pelo ID.
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado."));
    }

    // Cadastra ou atualiza um evento.
    public Evento salvar(Evento evento) {

        // Verifica se a capacidade máxima é maior que zero.
        if (evento.getCapacidadeMaxima() <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        return eventoRepository.save(evento);
    }

    // Exclui um evento pelo ID.
    public void excluir(Long id) {
        eventoRepository.deleteById(id);
    }
}