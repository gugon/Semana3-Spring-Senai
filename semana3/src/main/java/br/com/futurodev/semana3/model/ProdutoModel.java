package br.com.futurodev.semana3.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private double precoCompra;

    private double precoVenda;

    @CreationTimestamp
    private OffsetDateTime dataHoraCadastro;

    @UpdateTimestamp
    private OffsetDateTime dataHoraAlteracao;

    @OneToOne(mappedBy = "produto")
    private ItemPedidoModel itemPedido;


}