package br.com.controleeventos.controller;

import br.com.controleeventos.model.Evento;
import br.com.controleeventos.model.Participante;
import br.com.controleeventos.service.EventoService;
import br.com.controleeventos.service.InscricaoService;
import br.com.controleeventos.service.ParticipanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelas inscrições.
@Controller
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;
    private final EventoService eventoService;
    private final ParticipanteService participanteService;

    // Recebe os Services necessários para trabalhar com inscrições.
    public InscricaoController(
            InscricaoService inscricaoService,
            EventoService eventoService,
            ParticipanteService participanteService) {

        this.inscricaoService = inscricaoService;
        this.eventoService = eventoService;
        this.participanteService = participanteService;
    }

    // Abre a página para realizar uma nova inscrição.
    @GetMapping("/nova")
    public String nova(Model model) {

        // Busca os eventos cadastrados.
        List<Evento> eventos = eventoService.listar();

        // Busca os participantes cadastrados.
        List<Participante> participantes = participanteService.listar();

        // Envia os eventos para a página.
        model.addAttribute("eventos", eventos);

        // Envia os participantes para a página.
        model.addAttribute("participantes", participantes);

        return "inscricoes/formulario";
    }

    // Realiza uma nova inscrição.
    @PostMapping("/salvar")
    public String salvar(
            @RequestParam Long eventoId,
            @RequestParam Long participanteId,
            Model model) {

        try {

            // Tenta realizar a inscrição.
            inscricaoService.inscrever(eventoId, participanteId);

            // Se deu certo, volta para a página de eventos.
            return "redirect:/eventos";

        } catch (IllegalArgumentException e) {

            // Se ocorrer algum erro, mostra a mensagem na tela.
            model.addAttribute("erro", e.getMessage());

            // Busca novamente os eventos.
            model.addAttribute("eventos", eventoService.listar());

            // Busca novamente os participantes.
            model.addAttribute("participantes", participanteService.listar());

            return "inscricoes/formulario";
        }
    }

    // Mostra os participantes inscritos em um determinado evento.
    @GetMapping("/evento/{id}")
    public String participantesDoEvento(
            @PathVariable Long id,
            Model model) {

        // Busca o evento pelo ID.
        Evento evento = eventoService.buscarPorId(id);

        // Envia o evento para a página.
        model.addAttribute("evento", evento);

        return "inscricoes/participantes";
    }
}