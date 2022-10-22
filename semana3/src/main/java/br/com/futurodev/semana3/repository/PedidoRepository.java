package br.com.futurodev.semana3.repository;

import br.com.futurodev.semana3.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

}