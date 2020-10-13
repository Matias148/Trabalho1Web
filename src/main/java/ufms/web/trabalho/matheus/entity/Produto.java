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
    @Column(name = "PRO_ID", nullable = false)
    private Long id;

    @Column(name = "PRO_DES", nullable = false)
    private String descricao;

    @Column(name = "PRO_QUA_EST", nullable = false)
    private Long quantidadeEstoque;

    @Column(name = "PRO_IDA_PER", nullable = false)
    private Long idadePermitida;

    @Column(name = "PRO_PRE_COM", nullable = false)
    private Double precoCompra;

    @Column(name = "PRO_PRE_VEN_FIS", nullable = false)
    private Double precoVendaFisica;

    @Column(name = "PRO_PRE_VEN_JUR", nullable = false)
    private Double precoVendaJuridica;
}
