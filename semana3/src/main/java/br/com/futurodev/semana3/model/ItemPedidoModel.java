package br.com.futurodev.semana3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_pedido")
public class ItemPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantidade;

    private double valorItem;

    @OneToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id", foreignKey = @ForeignKey(name ="fk_produto"))
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "idPedido", referencedColumnName = "id", foreignKey = @ForeignKey(name ="fk_pedido"))
    @JsonBackReference
    private PedidoModel pedido;

}