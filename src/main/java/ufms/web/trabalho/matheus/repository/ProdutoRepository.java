package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.ItemPedido;
import ufms.web.trabalho.matheus.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//    @Query(nativeQuery = true, value = "SELECT * FROM TB_PEDIDO WHERE PED_ID LIKE :name")
//    List<Pedido> consultaTest(@Param("name") Long name);//String name?
}
