package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.entity.Usuario;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_PESSOA WHERE PES_ID LIKE :name")
    List<Pessoa> consultaTest(@Param("name") Long name);//String name?
}
