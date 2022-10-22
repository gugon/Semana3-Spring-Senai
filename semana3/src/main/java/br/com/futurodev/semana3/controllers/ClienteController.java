package br.com.futurodev.semana3.controllers;

import br.com.futurodev.semana3.dto.ClienteRepresentationModel;
import br.com.futurodev.semana3.input.ClienteInput;
import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.PedidoModel;
import br.com.futurodev.semana3.service.CadastroClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Clientes")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @ApiOperation("Salva um cliente")
    @PostMapping(value = "/", produces ="application/json")
    public ResponseEntity<ClienteRepresentationModel> cadastrar(@RequestBody ClienteInput clienteInput){
        ClienteModel cli = toDomainObject(clienteInput);
        cadastroClienteService.salvar(cli);
        return new ResponseEntity<ClienteRepresentationModel>(toModel(cli), HttpStatus.CREATED);
    }

    @ApiOperation("Listar clientes")
    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ClienteRepresentationModel>> getClientes(){
        List<ClienteModel> clientes = cadastroClienteService.getClientes();
        List<ClienteRepresentationModel> clientesRepresentationModel = toCollectionModel(clientes);
        return new ResponseEntity<List<ClienteRepresentationModel>>(clientesRepresentationModel,HttpStatus.OK);
    }

    private List<ClienteRepresentationModel> toCollectionModel(List<ClienteModel> clientesModel){
        return clientesModel.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private ClienteModel toDomainObject(ClienteInput clienteInput){

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteInput.getId());
        clienteModel.setNome(clienteInput.getNome());
        clienteModel.setCpf(clienteInput.getCpf());
        clienteModel.setRg(clienteInput.getRg());

//        PedidoModel pedidoModel = new PedidoModel();
//        pedidoModel.setId();
//        pedidoModel.setDataHoraCadastro();
//        pedidoModel.setDataHoraAlteracao();
//        pedidoModel.setCliente();
//        pedidoModel.setFormaPagamento();

        return clienteModel;
    }

    private ClienteRepresentationModel toModel(ClienteModel cli){
        ClienteRepresentationModel clienteRepresentationModel = new ClienteRepresentationModel();
        clienteRepresentationModel.setId(cli.getId());
        clienteRepresentationModel.setNome(cli.getNome());
        clienteRepresentationModel.setCpf(cli.getCpf());
        clienteRepresentationModel.setRg(cli.getRg());

        return clienteRepresentationModel;
    }
}
