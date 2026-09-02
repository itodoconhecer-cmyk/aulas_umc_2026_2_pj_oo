package controller;

import DTO.CadastroPessoaRequest;
import mapper.PessoaRequestMapper;
import model.Documento;
import model.Endereco;
import model.Pessoa;
import model.valueObjects.DemaisDados;
import model.valueObjects.Tipo;
import model.valueObjects.ValorDoc;

public class Main {

    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Rua Anjos", "12345", "Rio Branco");
        Endereco endereco2 = new Endereco("Rua das Flores", "456", "Sao Paulo");

        Documento documento1 = new Documento(new Tipo("RG"),new ValorDoc("23423423"),new DemaisDados("."));

        Pessoa pessoa = new Pessoa("João", 20, "O+", endereco1, documento1);
        pessoa.adicionarEndereco(endereco2);

        pessoa.exibirNome();
        pessoa.exibirIdade();
        pessoa.exibirTipoSanguineo();
        pessoa.exibirEnderecos();

        pessoa.fazerAniversario();
        pessoa.exibirIdade();


        CadastroPessoaRequest request = new CadastroPessoaRequest();
        request.setNome("Maria");
        request.setEmail("maria@email.com");

        CadastrarPessoaCommand command = new PessoaRequestMapper().toCommand(request);
    }
}
