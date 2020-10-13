package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;
import ufms.web.trabalho.matheus.enumeration.SituacaoPessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

    @Id
    @Column(name = "PES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne
    @JoinColumn(name = "PES_RES_ID", nullable = false)
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
