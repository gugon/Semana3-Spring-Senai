package br.com.futurodev.semana3.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(length = 15)
    private String cpf;

    @Column(length = 10)
    private String rg;

    @OneToOne(mappedBy = "cliente")
    private PedidoModel pedido;

}