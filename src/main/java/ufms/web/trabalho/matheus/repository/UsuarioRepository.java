package ufms.web.trabalho.matheus.repository;

import ufms.web.trabalho.matheus.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query(nativeQuery = true, value = "SELECT * FROM TB_USUARIO WHERE USU_ID LIKE :name")
//    List<Usuario> consultaTest(@Param("name") Long name);//String name?

    @Query("SELECT USU_LOG, USU_SEN FROM TB_USUARIO where USU_LOG LIKE :name AND USU_SEN LIKE :senha")
    Usuario consultaSqlNomeSenha(@Param("name") String name, @Param("senha") String senha);
}
