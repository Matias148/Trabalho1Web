package ufms.web.trabalho.matheus.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ufms.web.trabalho.matheus.entity.Fisica;
import ufms.web.trabalho.matheus.entity.Juridica;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.SituacaoPessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PessoaPojo {
    private Long id;
    private Pessoa idResponsavel;
    private TipoPessoa tipo;
    private SituacaoPessoa situacao = SituacaoPessoa.ATIVO;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private String cpf;
    //cada estado tem um tamanho
    private String rg;
    private String cnpj;

    public Fisica gerarFisica(PessoaPojo pessoa){
        Fisica ret = new Fisica();
        ret.setId(pessoa.getId());
        ret.setIdResponsavel(pessoa.getIdResponsavel());
        ret.setTipo(pessoa.getTipo());
        ret.setSituacao(pessoa.getSituacao());
        ret.setNome(pessoa.getNome());
        ret.setApelido(pessoa.getApelido());
        ret.setDataNascimento(pessoa.getDataNascimento());
        ret.setCpf(pessoa.getCpf());
        ret.setRg(pessoa.getRg());

        return ret;
    }

    public Juridica gerarJuridica(PessoaPojo pessoa){
        Juridica ret = new Juridica();
        ret.setId(pessoa.getId());
        ret.setIdResponsavel(pessoa.getIdResponsavel());
        ret.setTipo(pessoa.getTipo());
        ret.setSituacao(pessoa.getSituacao());
        ret.setNome(pessoa.getNome());
        ret.setApelido(pessoa.getApelido());
        ret.setDataNascimento(pessoa.getDataNascimento());
        ret.setCnpj(pessoa.getCnpj());

        return ret;
    }
}
