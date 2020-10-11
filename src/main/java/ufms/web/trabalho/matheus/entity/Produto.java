package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRO_ID")
    private Long id;

    @Column(name = "PRO_DES")
    private String descricao;

    @Column(name = "PRO_QUA_EST")
    private Long quantidadeEstoque;

    @Column(name = "PRO_IDA_PER")
    private Long idadePermitida;

    @Column(name = "PRO_PRE_COM")
    private Double precoCompra;

    @Column(name = "PRO_PRE_VEN_FIS")
    private Double precoVendaFisica;

    @Column(name = "PRO_PRE_VEN_JUR")
    private Double precoVendaJuridica;
}
