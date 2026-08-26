package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    public String nome;
    public int idade;
    public String tipoSanguineo;
    private final List<Endereco> enderecos;

    public Pessoa(String nome, int idade, String tipoSanguineo, Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Pessoa deve possuir pelo menos um endereco.");
        }
        this.nome = nome;
        this.idade = idade;
        this.tipoSanguineo = tipoSanguineo;
        this.enderecos = new ArrayList<>();
        this.enderecos.add(endereco);
    }

    public void adicionarEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco nao pode ser nulo.");
        }
        enderecos.add(endereco);
    }

    public void exibirNome() {
        System.out.println(nome + " ola Mundo!");
    }

    public void exibirIdade() {
        System.out.println("Idade: " + idade);
    }

    public void exibirTipoSanguineo() {
        System.out.println("Tipo Sanguineo: " + tipoSanguineo);
    }

    public void exibirEnderecos() {
        for (Endereco endereco : enderecos) {
            endereco.exibir();
        }
    }

    public void fazerAniversario() {
        idade++;
    }
}
