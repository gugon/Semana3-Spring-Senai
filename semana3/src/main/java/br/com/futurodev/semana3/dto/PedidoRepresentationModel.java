package br.com.futurodev.semana3.dto;

import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.FormaPagamentoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoRepresentationModel {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime dataHoraCadastro;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime dataHoraAlteracao;

    private ClienteModel cliente;

    private FormaPagamentoModel formaPagamento;

    private List<ItemPedidoRepresentationModel> itens = new ArrayList<ItemPedidoRepresentationModel>();
}
