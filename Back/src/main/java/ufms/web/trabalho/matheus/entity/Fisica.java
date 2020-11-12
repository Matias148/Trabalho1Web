package ufms.web.trabalho.matheus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TB_PES_FIS")
@PrimaryKeyJoinColumn(name = "PES_ID")
public class Fisica extends Pessoa {

    @Column(name = "PES_FIS_CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "PES_FIS_RG", nullable = false)//cada estado tem um tamanho
    private String rg;

    public Fisica(Long id) {
        super(id);
    }
}
