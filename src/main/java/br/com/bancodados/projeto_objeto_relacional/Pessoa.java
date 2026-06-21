package br.com.bancodados.projeto_objeto_relacional;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ElementCollection
    private List<String> telefones;

    public Pessoa() {} // O JPA exige um construtor vazio

    public Pessoa(String nome, List<String> telefones) {
        this.nome = nome;
        this.telefones = telefones;
    }
}