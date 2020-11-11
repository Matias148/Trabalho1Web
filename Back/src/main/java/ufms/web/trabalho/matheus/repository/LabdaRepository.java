package ufms.web.trabalho.matheus.repository;

import org.springframework.stereotype.Component;
import ufms.web.trabalho.matheus.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

@Component
public class LabdaRepository {
    private List<Pessoa> pessoaList = new ArrayList<>();

    public LabdaRepository(){
        //popular BD
    }
}
