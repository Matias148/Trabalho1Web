package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.Fisica;
import ufms.web.trabalho.matheus.entity.Pessoa;

import java.util.List;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<Fisica, Long> {

    //@Query(nativeQuery = true, value = "SELECT * FROM TB_PESSOA WHERE PES_ID LIKE :name")
    //List<Pessoa> consultaTest(@Param("name") Long name);//String name?
}
