package br.com.futurodev.semana3.controllers;

import br.com.futurodev.semana3.dto.ItemPedidoRepresentationModel;
import br.com.futurodev.semana3.dto.ProdutoRepresentationModel;
import br.com.futurodev.semana3.input.ProdutoInput;
import br.com.futurodev.semana3.model.ProdutoModel;
import br.com.futurodev.semana3.service.CadastroProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Produtos")
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @ApiOperation("Salva um produto")
    @PostMapping(value = "/", produces ="application/json")
    public ResponseEntity<ProdutoRepresentationModel> cadastrar(@RequestBody ProdutoInput produtoInput){
        ProdutoModel produto = toDomainObject(produtoInput);
        cadastroProdutoService.salvar(produto);
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.CREATED);
    }

    @ApiOperation("Lista produtos")
    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ProdutoRepresentationModel>> getProdutos(){
        List<ProdutoModel> produtos = cadastroProdutoService.getProdutos();
        List<ProdutoRepresentationModel> produtosRepresentationModels = toCollectionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModels,HttpStatus.OK);
    }

    private List<ProdutoRepresentationModel> toCollectionModel(List<ProdutoModel> produtosModel){
        return produtosModel.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private ProdutoModel toDomainObject(ProdutoInput produtoInput){

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoInput.getId());
        produtoModel.setDataHoraAlteracao(produtoInput.getDataHoraAlteracao());
        produtoModel.setDataHoraCadastro(produtoInput.getDataHoraCadastro());
        produtoModel.setDataHoraAlteracao(produtoInput.getDataHoraAlteracao());
        produtoModel.setDescricao(produtoInput.getDescricao());
        produtoModel.setPrecoCompra(produtoInput.getPrecoCompra());
        produtoModel.setPrecoVenda(produtoInput.getPrecoVenda());

        return produtoModel;
    }

    private ProdutoRepresentationModel toModel(ProdutoModel produtoModel){
        ProdutoRepresentationModel produtoRepresentationModel = new ProdutoRepresentationModel();
        produtoRepresentationModel.setId(produtoModel.getId());
        produtoRepresentationModel.setDataHoraAlteracao(produtoModel.getDataHoraAlteracao());
        produtoRepresentationModel.setDataHoraCadastro(produtoModel.getDataHoraCadastro());
        produtoRepresentationModel.setDescricao(produtoModel.getDescricao());
        produtoRepresentationModel.setPrecoCompra(produtoModel.getPrecoCompra());
        produtoRepresentationModel.setPrecoVenda(produtoModel.getPrecoVenda());

        ItemPedidoRepresentationModel item = new ItemPedidoRepresentationModel();
        produtoRepresentationModel.setItemPedido(item);


        return produtoRepresentationModel;
    }
}
