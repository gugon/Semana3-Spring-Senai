package br.com.futurodev.semana3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "formaPagamento")
public class FormaPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToOne(mappedBy = "formaPagamento")
    private PedidoModel pedido;

}