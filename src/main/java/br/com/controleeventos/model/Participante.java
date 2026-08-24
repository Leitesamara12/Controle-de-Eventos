package br.com.controleeventos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity informa ao JPA que esta classe representa uma tabela no banco.
@Entity
public class Participante {

    // @Id identifica cada participante.
    @Id

    // O banco gera o ID automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do participante.
    private String nome;

    // E-mail do participante.
    private String email;

    // Telefone do participante.
    private String telefone;

    // Construtor vazio usado pelo JPA.
    public Participante() {
    }

    // Retorna o ID do participante.
    public Long getId() {
        return id;
    }

    // Altera o ID do participante.
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o nome do participante.
    public String getNome() {
        return nome;
    }

    // Altera o nome do participante.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o e-mail do participante.
    public String getEmail() {
        return email;
    }

    // Altera o e-mail do participante.
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o telefone do participante.
    public String getTelefone() {
        return telefone;
    }

    // Altera o telefone do participante.
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}