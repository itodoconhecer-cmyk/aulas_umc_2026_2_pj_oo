package controller;

import model.Pessoa;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();

        pessoa.nome = "João";
        pessoa.tipoSanguineo = "AB-";
        pessoa.exibirTipoSanguineo();

        Pessoa pessoa2 = new Pessoa("Pedro", 20);

        pessoa2.exibirNome();
        pessoa2.exibirIdade();



    }
}
