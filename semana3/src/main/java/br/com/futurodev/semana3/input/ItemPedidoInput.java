package br.com.futurodev.semana3.input;

import br.com.futurodev.semana3.dto.PedidoRepresentationModel;
import br.com.futurodev.semana3.dto.ProdutoRepresentationModel;
import lombok.Data;

@Data
public class ItemPedidoInput {

    private Long id;

    private double quantidade;

    private double valorItem;

    private ProdutoRepresentationModel produto;

    private PedidoRepresentationModel pedido;
}
