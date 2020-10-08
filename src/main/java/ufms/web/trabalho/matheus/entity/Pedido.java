package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;
import ufms.web.trabalho.matheus.enumeration.StatusPedido;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @Column(name = "PED_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "PES_ID")
    private Long idPessoa;

    @Column(name = "PES_STA")
    private StatusPedido status;

    @Column(name = "PED_DAT_COM")
    private Date dataCompra;

    @Column(name = "PED_DAT_ENT")
    private Date dataEntrega;

    @Column(name = "PED_DES")
    private Double percentualDesconto;
}
