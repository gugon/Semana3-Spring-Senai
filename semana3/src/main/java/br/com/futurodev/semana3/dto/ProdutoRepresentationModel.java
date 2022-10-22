package br.com.futurodev.semana3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ProdutoRepresentationModel {
    private Long id;

    private String descricao;

    private double precoCompra;

    private double precoVenda;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime dataHoraCadastro;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime dataHoraAlteracao;


    private ItemPedidoRepresentationModel itemPedido;
}
