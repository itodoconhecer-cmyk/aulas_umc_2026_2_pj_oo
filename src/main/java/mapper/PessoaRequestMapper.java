package mapper;

import DTO.CadastroPessoaRequest;
import command.CadastrarPessoaCommand;
import model.valueObjects.Email;
import model.valueObjects.NomePessoa;

public class PessoaRequestMapper {

    public CadastrarPessoaCommand toCommand(CadastroPessoaRequest request)
    {

        return new CadastrarPessoaCommand(request.getNome(),request.getEmail());

    }
}
