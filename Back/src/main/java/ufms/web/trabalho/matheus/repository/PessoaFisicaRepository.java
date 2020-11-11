package ufms.web.trabalho.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufms.web.trabalho.matheus.entity.Fisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<Fisica, Long> {

    //@Query(nativeQuery = true, value = "SELECT * FROM TB_PESSOA WHERE PES_ID LIKE :name")
    //List<Pessoa> consultaTest(@Param("name") Long name);//String name?
}
