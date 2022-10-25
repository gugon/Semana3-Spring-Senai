package br.com.futurodev.semana3.controllers;

import br.com.futurodev.semana3.dto.ClienteRepresentationModel;
import br.com.futurodev.semana3.dto.ItemPedidoRepresentationModel;
import br.com.futurodev.semana3.dto.PedidoRepresentationModel;
import br.com.futurodev.semana3.input.ClienteInput;
import br.com.futurodev.semana3.input.PedidoInput;
import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.ItemPedidoModel;
import br.com.futurodev.semana3.model.PedidoModel;
import br.com.futurodev.semana3.service.CadastroClienteService;
import br.com.futurodev.semana3.service.CadastroPedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Api(tags = "Pedidos")
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private CadastroPedidoService cadastroPedidoService;

    @ApiOperation("Salva um pedido")
    @PostMapping(value = "/", produces ="application/json")
    public ResponseEntity<PedidoRepresentationModel> cadastrar(@RequestBody PedidoInput pedidoInput){
        PedidoModel pedidoModel = toDomainObject(pedidoInput);
        cadastroPedidoService.salvar(pedidoModel);
        return new ResponseEntity<PedidoRepresentationModel>(toModel(pedidoModel), HttpStatus.CREATED);
    }

    @ApiOperation("Listar pedidos")
    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<PedidoRepresentationModel>> getPedidos(){
        List<PedidoModel> pedidos = cadastroPedidoService.getPedidos();
        List<PedidoRepresentationModel> pedidosRepresentationModel = toCollectionModel(pedidos);
        return new ResponseEntity<List<PedidoRepresentationModel>>(pedidosRepresentationModel,HttpStatus.OK);
    }

    private List<PedidoRepresentationModel> toCollectionModel(List<PedidoModel> pedidoModel){
        return pedidoModel.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private PedidoModel toDomainObject(PedidoInput pedidoInput){

        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setId(pedidoInput.getId());
        pedidoModel.setDataHoraAlteracao(pedidoInput.getDataHoraAlteracao());
        pedidoModel.setDataHoraCadastro(pedidoInput.getDataHoraCadastro());
        pedidoModel.setCliente(pedidoInput.getCliente());
        pedidoModel.setFormaPagamento(pedidoInput.getFormaPagamento());

        for (int i=0; i<pedidoModel.getItens().size(); i++) {
            ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
            itemPedidoModel.setId(pedidoModel.getItens().get(i).getId());
            itemPedidoModel.setQuantidade(pedidoModel.getItens().get(i).getQuantidade());
            itemPedidoModel.setValorItem(pedidoModel.getItens().get(i).getValorItem());

            pedidoModel.getItens().add(itemPedidoModel);
        }
        return pedidoModel;
    }

    private PedidoRepresentationModel toModel(PedidoModel pedido){
        PedidoRepresentationModel pedidoRepresentation = new PedidoRepresentationModel();
        pedidoRepresentation.setId(pedido.getId());
        pedidoRepresentation.setDataHoraAlteracao(pedido.getDataHoraAlteracao());
        pedidoRepresentation.setDataHoraCadastro(pedido.getDataHoraCadastro());
//        pedidoRepresentation.setCliente(pedido.getCliente());
//        pedidoRepresentation.setFormaPagamento(pedido.getFormaPagamento());



//        for (int i=0; i<pedido.getItens().size(); i++){
//            ItemPedidoRepresentationModel item = new ItemPedidoRepresentationModel();
//            item.setId(pedido.getItens().get(i).getId());
//            item.setQuantidade(pedido.getItens().get(i).getQuantidade());
//            item.setValorItem(pedido.getItens().get(i).getValorItem());
////            item.setPedido(pedido.getItens().get(i).getPedido(new Pedido));
////            item.setProduto(pedido.getItens().get(i).getProduto());
//
//            pedidoRepresentation.getItens().add(item);
//        }

        return pedidoRepresentation;
    }
}
