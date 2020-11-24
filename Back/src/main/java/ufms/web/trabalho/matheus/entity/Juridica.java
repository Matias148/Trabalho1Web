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
@Table(name = "TB_PES_JUR")
@PrimaryKeyJoinColumn(name = "PES_ID")
public class Juridica extends Pessoa {

    @Column(name = "PES_JUR_CNPJ", length = 14, nullable = false)
    private String cnpj;

//    public Juridica(Long id) {
//        super(id);
//    }
}
