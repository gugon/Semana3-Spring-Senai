package br.com.futurodev.semana3.controllers;

import br.com.futurodev.semana3.dto.FormaPagamentoRepresentationModel;
import br.com.futurodev.semana3.input.FormaPagamentoInput;
import br.com.futurodev.semana3.model.FormaPagamentoModel;
import br.com.futurodev.semana3.service.CadastroFormaPagamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Forma de Pagamento")
@RestController
@RequestMapping(value = "/pagamento")
public class FormaPagamentoController {

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;

    @ApiOperation("Salva uma forma de pagamento")
    @PostMapping(value = "/", produces ="application/json")
    public ResponseEntity<FormaPagamentoRepresentationModel> cadastrar(@RequestBody FormaPagamentoInput pagamentoInput){
        FormaPagamentoModel pagamento = toDomainObject(pagamentoInput);
        cadastroFormaPagamentoService.salvar(pagamento);
        return new ResponseEntity<FormaPagamentoRepresentationModel>(toModel(pagamento), HttpStatus.CREATED);
    }

    @ApiOperation("Listar formas de pagamento")
    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<FormaPagamentoRepresentationModel>> getFormaPagamentos(){
        List<FormaPagamentoModel> pagamentos = cadastroFormaPagamentoService.getFormaPagamentos();
        List<FormaPagamentoRepresentationModel> formaPagamentoRepresentationModels = toCollectionModel(pagamentos);
        return new ResponseEntity<List<FormaPagamentoRepresentationModel>>(formaPagamentoRepresentationModels,HttpStatus.OK);
    }

    private List<FormaPagamentoRepresentationModel> toCollectionModel(List<FormaPagamentoModel> pagamentosModel){
        return pagamentosModel.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private FormaPagamentoModel toDomainObject(FormaPagamentoInput formaPagamentoInput){

        FormaPagamentoModel formaPagamentoModel = new FormaPagamentoModel();
        formaPagamentoModel.setId(formaPagamentoInput.getId());
        formaPagamentoModel.setDescricao(formaPagamentoInput.getDescricao());

        return formaPagamentoModel;
    }

    private FormaPagamentoRepresentationModel toModel(FormaPagamentoModel pagamento){
        FormaPagamentoRepresentationModel formaPagamentoRepresentationModel = new FormaPagamentoRepresentationModel();
        formaPagamentoRepresentationModel.setId(pagamento.getId());
        formaPagamentoRepresentationModel.setDescricao(pagamento.getDescricao());

        return formaPagamentoRepresentationModel;
    }
}