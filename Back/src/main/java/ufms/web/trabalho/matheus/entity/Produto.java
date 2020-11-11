package ufms.web.trabalho.matheus.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private BigDecimal precoCompra;

    @Column(name = "PRO_PRE_VEN_FIS", nullable = false)
    private BigDecimal precoVendaFisica;

    @Column(name = "PRO_PRE_VEN_JUR", nullable = false)
    private BigDecimal precoVendaJuridica;
}
