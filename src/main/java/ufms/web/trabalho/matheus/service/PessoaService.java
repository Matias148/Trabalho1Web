package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.repository.PessoaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(Pessoa pessoa) {
        LocalDate maioridade = LocalDate.parse("2020-10-30");
        if (//maioridade.after(pessoa.getDataNascimento())
        maioridade.isAfter(pessoa.getDataNascimento())) {//maior de idade
            return pessoaRepository.save(pessoa);
        }else{
            if (pessoa.getIdResponsavel() == null && pessoa.getTipo() == TipoPessoa.FISICA){
                return null;
            }else{
                return pessoaRepository.save(pessoa);
            }
        }
    }

    public Optional<Pessoa> buscarId(Long id){
        return pessoaRepository.findById(id);
    }

    public void deletar(Long id){
        pessoaRepository.deleteById(id);
    }

    public Pessoa alterar(Long id, Pessoa usuario){
        return pessoaRepository.save(usuario);
    }
}
