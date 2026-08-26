package controller;

import model.Endereco;
import model.Pessoa;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 20, "O+");

        pessoa.exibirNome();
        pessoa.exibirIdade();
        pessoa.exibirTipoSanguineo();

        pessoa.fazerAniversario();
        pessoa.exibirIdade();

        Endereco endereco = new Endereco();
        endereco.setCidade("Rio Branco");
        endereco.setNumero("12345");
        endereco.setRua("Rua Anjos");

        endereco.exibir();

    }
}
