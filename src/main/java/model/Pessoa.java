package model;

public class Pessoa {

    public String nome;
    public int idade;
    public String tipoSanguineo;

    public Pessoa(String nome, int idade, String tipoSanguineo) {
        this.nome = nome;
        this.idade = idade;
        this.tipoSanguineo = tipoSanguineo;
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

}
