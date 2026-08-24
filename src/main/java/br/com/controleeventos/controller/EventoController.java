package br.com.controleeventos.controller;

import br.com.controleeventos.model.Evento;
import br.com.controleeventos.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelas páginas e operações relacionadas aos eventos.
@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    // Recebe o Service responsável pelas regras dos eventos.
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    // Lista todos os eventos cadastrados.
    @GetMapping
    public String listar(Model model) {

        // Busca os eventos no banco através do Service.
        List<Evento> eventos = eventoService.listar();

        // Envia a lista de eventos para a página HTML.
        model.addAttribute("eventos", eventos);

        // Abre a página eventos/lista.html.
        return "eventos/lista";
    }

    // Abre o formulário para cadastrar um novo evento.
    @GetMapping("/novo")
    public String novo(Model model) {

        // Cria um evento vazio para preencher o formulário.
        model.addAttribute("evento", new Evento());

        return "eventos/formulario";
    }

    // Salva um novo evento ou atualiza um evento existente.
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Evento evento) {

        // Envia o evento para o Service salvar no banco.
        eventoService.salvar(evento);

        // Depois de salvar, volta para a lista de eventos.
        return "redirect:/eventos";
    }

    // Abre o formulário de edição de um evento.
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        // Busca o evento pelo ID.
        Evento evento = eventoService.buscarPorId(id);

        // Envia o evento encontrado para o formulário.
        model.addAttribute("evento", evento);

        return "eventos/formulario";
    }

    // Exclui um evento pelo ID.
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        // Exclui o evento do banco.
        eventoService.excluir(id);

        // Volta para a lista.
        return "redirect:/eventos";
    }
}