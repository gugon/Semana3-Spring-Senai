package br.com.futurodev.semana3.dto;

import lombok.Data;

@Data
public class ItemPedidoRepresentationModel {

    private Long id;

    private double quantidade;

    private double valorItem;

    private ProdutoRepresentationModel produto;

    private PedidoRepresentationModel pedido;

}
