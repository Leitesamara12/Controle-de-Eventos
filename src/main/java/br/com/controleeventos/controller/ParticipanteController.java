package br.com.controleeventos.controller;

import br.com.controleeventos.model.Participante;
import br.com.controleeventos.service.ParticipanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelas páginas e operações dos participantes.
@Controller
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    // Recebe o Service responsável pelas regras dos participantes.
    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    // Lista todos os participantes cadastrados.
    @GetMapping
    public String listar(Model model) {

        // Busca os participantes no banco.
        List<Participante> participantes = participanteService.listar();

        // Envia os participantes para a página HTML.
        model.addAttribute("participantes", participantes);

        return "participantes/lista";
    }

    // Abre o formulário para cadastrar um participante.
    @GetMapping("/novo")
    public String novo(Model model) {

        // Cria um participante vazio para preencher o formulário.
        model.addAttribute("participante", new Participante());

        return "participantes/formulario";
    }

    // Salva um novo participante ou atualiza um existente.
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Participante participante) {

        // Envia o participante para o Service salvar no banco.
        participanteService.salvar(participante);

        // Depois de salvar, volta para a lista.
        return "redirect:/participantes";
    }

    // Abre o formulário para editar um participante.
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        // Busca o participante pelo ID.
        Participante participante = participanteService.buscarPorId(id);

        // Envia o participante encontrado para o formulário.
        model.addAttribute("participante", participante);

        return "participantes/formulario";
    }

    // Exclui um participante pelo ID.
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        // Exclui o participante do banco.
        participanteService.excluir(id);

        // Volta para a lista.
        return "redirect:/participantes";
    }
}