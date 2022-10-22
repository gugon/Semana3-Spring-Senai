package br.com.futurodev.semana3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataHoraCadastro;

    @UpdateTimestamp
    private OffsetDateTime dataHoraAlteracao;

    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", foreignKey = @ForeignKey(name ="fk_cliente"))
    private ClienteModel cliente;

    @OneToOne
    @JoinColumn(name = "idFormaPagamento", referencedColumnName = "id", foreignKey = @ForeignKey(name ="fk_forma_pagamento"))
    private FormaPagamentoModel formaPagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemPedidoModel> itens = new ArrayList<>();

}