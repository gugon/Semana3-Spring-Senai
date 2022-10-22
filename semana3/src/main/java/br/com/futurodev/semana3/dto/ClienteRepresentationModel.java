package br.com.futurodev.semana3.dto;

import lombok.Data;

@Data
public class ClienteRepresentationModel {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private PedidoRepresentationModel pedido;

}
