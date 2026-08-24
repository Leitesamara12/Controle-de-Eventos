package br.com.controleeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controller responsável pela página inicial do sistema.
@Controller
public class HomeController {

    // Quando acessar http://localhost:8080/
    // o Spring vai abrir o arquivo index.html.
    @GetMapping("/")
    public String inicio() {

        // "index" significa: procurar index.html
        // dentro da pasta templates.
        return "index";
    }
}