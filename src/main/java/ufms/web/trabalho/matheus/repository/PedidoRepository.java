package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.Pedido;
import ufms.web.trabalho.matheus.entity.Pessoa;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_PEDIDO WHERE PED_ID LIKE :name")
    List<Pedido> consultaTest(@Param("name") Long name);//String name?
}
