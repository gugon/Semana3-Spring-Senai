package br.com.futurodev.semana3.service;

import br.com.futurodev.semana3.model.PedidoModel;
import br.com.futurodev.semana3.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public PedidoModel salvar(PedidoModel pedido){
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void delete(Long idPedido){
        pedidoRepository.deleteById(idPedido);
    }


    public List<PedidoModel> getPedidos(){
        return pedidoRepository.findAll();
    }
}
