package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity @IdClass(ItemPedidoId.class)
@Table(name = "TB_ITE_PED")
public class ItemPedido {

    @Id
    @Column(name = "ITE_PED_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "PED_ID")
    private Pedido idPedido;
//
    @Id
    @ManyToOne//?
    @JoinColumn(name = "PRO_ID")
    private Produto idProduto;

    @Column(name = "ITE_PED_QUA")
    private Long quantidade;
}

class ItemPedidoId implements Serializable {
    Long id;
    Pedido idPedido;
    Produto idProduto;
}
