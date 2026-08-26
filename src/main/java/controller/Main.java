package controller;

import model.Endereco;
import model.Pessoa;

public class Main {

    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Rua Anjos", "12345", "Rio Branco");
        Endereco endereco2 = new Endereco("Rua das Flores", "456", "Sao Paulo");

        Pessoa pessoa = new Pessoa("João", 20, "O+", endereco1);
        pessoa.adicionarEndereco(endereco2);

        pessoa.exibirNome();
        pessoa.exibirIdade();
        pessoa.exibirTipoSanguineo();
        pessoa.exibirEnderecos();

        pessoa.fazerAniversario();
        pessoa.exibirIdade();
    }
}
