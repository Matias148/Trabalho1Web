package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;
import ufms.web.trabalho.matheus.enumeration.SituacaoPessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @Column(name = "PES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "PES_RES_ID")
    private Pessoa idResponsavel;

    @Column(name = "PES_TIP", nullable = false)
    private TipoPessoa tipo;

    @Column(name = "PES_SIT", nullable = false)
    private SituacaoPessoa situacao;

    @Column(name = "PES_NOM", nullable = false)
    private String nome;

    @Column(name = "PES_APE", nullable = false)
    private String apelido;

    @Column(name = "PES_DAT", nullable = false)
    private LocalDate dataNascimento;
}
