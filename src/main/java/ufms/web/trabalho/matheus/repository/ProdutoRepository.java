package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
//    @Query("SELECT p from Produto p where p.idadePermitida <= idade")
//    List<Produto> consultaComIdade(@Param("idade") Long idade);
}
