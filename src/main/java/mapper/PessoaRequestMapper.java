package mapper;

import DTO.CadastroPessoaRequest;
import model.valueObjects.Email;
import model.valueObjects.NomePessoa;

public class PessoaRequestMapper {

    public CadastrarPessoaCommand toCommand( CadastroPessoaRequest request)
    {
        return new CadastrarPessoaCommand(new NomePessoa(request.getNome()), new Email(request.getEmail()));
    }
}
