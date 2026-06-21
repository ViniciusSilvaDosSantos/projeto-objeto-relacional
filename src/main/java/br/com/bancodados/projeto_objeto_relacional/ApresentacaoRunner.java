package br.com.bancodados.projeto_objeto_relacional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class ApresentacaoRunner implements CommandLineRunner {

    @Autowired
    private PessoaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSISTEMA OBJETO-RELACIONAL (PostgreSQL)");
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite os telefones separados por vírgula (ex: 1111,2222): ");
        String telefonesInput = scanner.nextLine();
        List<String> telefones = Arrays.asList(telefonesInput.split(","));

        Pessoa p = new Pessoa(nome, telefones);

        System.out.println("\nO Hibernate vai traduzir o objeto para SQL agora:");
        repository.save(p);

        System.out.println("\nOs comandos SQL gerados acima");
    }
}