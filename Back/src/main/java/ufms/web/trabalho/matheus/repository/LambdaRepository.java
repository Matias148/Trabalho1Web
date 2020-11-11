package ufms.web.trabalho.matheus.repository;

import org.springframework.stereotype.Component;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.EGenero;

import java.util.Arrays;
import java.util.List;

@Component
public class LambdaRepository {

    private List<Pessoa> PessoaList;

    public LambdaRepository() {
        this.PessoaList = Arrays.asList(
                Pessoa.builder().id(1L).nome("Eduardo").genero(EGenero.MASCULINO).idade(5L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(2L).nome("Eduarda").genero(EGenero.FEMININO).idade(5L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(3L).nome("Bruno").genero(EGenero.MASCULINO).idade(10L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(4L).nome("Bruna").genero(EGenero.FEMININO).idade(10L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(5L).nome("Fernando").genero(EGenero.MASCULINO).idade(15L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(6L).nome("Fernanda").genero(EGenero.FEMININO).idade(15L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(7L).nome("Rafael").genero(EGenero.MASCULINO).idade(20L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(8L).nome("Rafaela").genero(EGenero.FEMININO).idade(20L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(9L).nome("Joao").genero(EGenero.MASCULINO).idade(25L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(10L).nome("Juana").genero(EGenero.FEMININO).idade(25L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(11L).nome("Mario").genero(EGenero.MASCULINO).idade(30L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(12L).nome("Maria").genero(EGenero.FEMININO).idade(30L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(13L).nome("Marcio").genero(EGenero.MASCULINO).idade(50L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(14L).nome("Marcia").genero(EGenero.FEMININO).idade(50L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(15L).nome("Juliano").genero(EGenero.MASCULINO).idade(55L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(16L).nome("Juliana").genero(EGenero.FEMININO).idade(55L).realizouAlgumPedido(Boolean.TRUE).build(),
                Pessoa.builder().id(17L).nome("Antonio").genero(EGenero.MASCULINO).idade(65L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(18L).nome("Antonia").genero(EGenero.FEMININO).idade(65L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(19L).nome("Fabricio").genero(EGenero.MASCULINO).idade(70L).realizouAlgumPedido(Boolean.FALSE).build(),
                Pessoa.builder().id(20L).nome("Fabricia").genero(EGenero.FEMININO).idade(70L).realizouAlgumPedido(Boolean.FALSE).build()
        );
    }

    public List<Pessoa> findAll() {
        return this.PessoaList;
    }
}
