package br.com.futurodev.semana3.input;

import br.com.futurodev.semana3.model.ItemPedidoModel;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Data
public class ProdutoInput {

    private Long id;

    private String descricao;

    private double precoCompra;

    private double precoVenda;

    @CreationTimestamp
    private OffsetDateTime dataHoraCadastro;

    @UpdateTimestamp
    private OffsetDateTime dataHoraAlteracao;

    private ItemPedidoModel itemPedido;
}
