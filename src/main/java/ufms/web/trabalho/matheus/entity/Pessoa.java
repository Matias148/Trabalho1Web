package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import ufms.web.trabalho.matheus.enumeration.SituacaoPessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Pessoa {

    @Id
    @Column(name = "PES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "PES_RES_ID")
    private Long idResponsavel;

    @Column(name = "PES_TIP", nullable = false)
    private TipoPessoa tipo;

    @Column(name = "PES_SIT", nullable = false)
    private SituacaoPessoa situacao;

    @Column(name = "PES_NOM", nullable = false)
    private String nome;

    @Column(name = "PES_APE", nullable = false)
    private String apelido;

    @Column(name = "PES_DAT", nullable = false)
    private Date dataNascimento; //data?
}
