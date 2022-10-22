package br.com.futurodev.semana3.service;

import br.com.futurodev.semana3.model.ClienteModel;
import br.com.futurodev.semana3.model.FormaPagamentoModel;
import br.com.futurodev.semana3.model.ProdutoModel;
import br.com.futurodev.semana3.repository.FormaPagamentoRepository;
import br.com.futurodev.semana3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoModel salvar(ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    @Transactional
    public void delete(Long idProduto){
        produtoRepository.deleteById(idProduto);
    }


    public List<ProdutoModel> getProdutos(){
        return produtoRepository.findAll();
    }
}
