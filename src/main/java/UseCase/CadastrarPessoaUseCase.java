package UseCase;

import command.CadastrarPessoaCommand;
import model.Pessoa;

public class CadastrarPessoaUseCase {

    public Pessoa executar(CadastrarPessoaCommand command) {

        Pessoa pessoa = new Pessoa(command.getNomePessoa(), command.getEmailPessoa());

        return pessoa;
    }
}
