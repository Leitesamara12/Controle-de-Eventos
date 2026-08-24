package br.com.controleeventos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// @Entity informa ao JPA que esta classe representa uma tabela no banco.
@Entity
public class Evento {

    // @Id define o campo que identifica cada evento.
    @Id

    // O banco gera o ID automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do evento.
    private String nome;

    // Local onde o evento acontecerá.
    private String local;

    // Data em que o evento acontecerá.
    private LocalDate data;

    // Quantidade máxima de participantes permitida.
    private Integer capacidadeMaxima;

    // Um evento pode possuir várias inscrições.
    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes = new ArrayList<>();

    // Construtor vazio usado pelo JPA para criar objetos Evento.
    public Evento() {
    }

    // Retorna o ID do evento.
    public Long getId() {
        return id;
    }

    // Altera o ID do evento.
    public void setId(Long id) {
        this.id = id;
    }

    // Retorna o nome do evento.
    public String getNome() {
        return nome;
    }

    // Altera o nome do evento.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o local do evento.
    public String getLocal() {
        return local;
    }

    // Altera o local do evento.
    public void setLocal(String local) {
        this.local = local;
    }

    // Retorna a data do evento.
    public LocalDate getData() {
        return data;
    }

    // Altera a data do evento.
    public void setData(LocalDate data) {
        this.data = data;
    }

    // Retorna a capacidade máxima do evento.
    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    // Altera a capacidade máxima do evento.
    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Retorna a lista de inscrições deste evento.
    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    // Altera a lista de inscrições do evento.
    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}