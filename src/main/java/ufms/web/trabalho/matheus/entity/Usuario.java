package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @Column(name = "USU_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USU_ISA", nullable = false)
    private boolean isAdministrador;

    @Column(name = "USU_LOG", nullable = false)
    private String login;

    @Column(name = "USU_SEN", nullable = false)
    private String senha;

    @OneToOne
    @JoinColumn(name = "PES_ID", nullable = false)
    private Pessoa pessoa;
}
