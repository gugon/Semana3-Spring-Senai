package br.com.futurodev.semana3.input;

import br.com.futurodev.semana3.dto.ItemPedidoRepresentationModel;
import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.FormaPagamentoModel;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoInput {

    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataHoraCadastro;

    @UpdateTimestamp
    private OffsetDateTime dataHoraAlteracao;

    private ClienteModel cliente;

    private FormaPagamentoModel formaPagamento;

    private List<ItemPedidoRepresentationModel> itens = new ArrayList<ItemPedidoRepresentationModel>();
}
