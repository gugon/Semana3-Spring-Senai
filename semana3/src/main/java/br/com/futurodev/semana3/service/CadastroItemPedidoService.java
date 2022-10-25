package br.com.futurodev.semana3.service;

import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.ItemPedidoModel;
import br.com.futurodev.semana3.repository.ClienteRepository;
import br.com.futurodev.semana3.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public ItemPedidoModel salvar(ItemPedidoModel item){
        return itemPedidoRepository.save(item);
    }

    @Transactional
    public void delete(Long idItem){
        itemPedidoRepository.deleteById(idItem);
    }


    public List<ItemPedidoModel> getItensPedido(){
        return itemPedidoRepository.findAll();
    }
}
