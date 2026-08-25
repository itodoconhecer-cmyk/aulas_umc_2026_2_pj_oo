package model;

public class Pessoa {

    public String nome;
    public int idade;
    public String tipoSanguineo;

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
