package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;
import ufms.web.trabalho.matheus.enumeration.StatusPedido;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @Column(name = "PED_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToMany
    @JoinColumn(name = "PES_ID", nullable = false)
    private Long idPessoa;

    @Column(name = "PES_STA", nullable = false)
    private StatusPedido status;

    @Column(name = "PED_DAT_COM", nullable = false)
    private Date dataCompra;

    @Column(name = "PED_DAT_ENT", nullable = false)
    private Date dataEntrega;

    @Column(name = "PED_DES", nullable = false)
    private Double percentualDesconto;
}
