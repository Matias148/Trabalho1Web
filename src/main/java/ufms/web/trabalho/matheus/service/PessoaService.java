package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.pojo.PessoaPojo;
import ufms.web.trabalho.matheus.repository.PessoaFisicaRepository;
import ufms.web.trabalho.matheus.repository.PessoaJuridicaRepository;
import ufms.web.trabalho.matheus.repository.PessoaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

//    public Pessoa salvar(Pessoa pessoa) {
//        LocalDate maioridade = LocalDate.parse("2002-10-30");
//        if (maioridade.isAfter(pessoa.getDataNascimento())) {//maior de idade
//            return pessoaRepository.save(pessoa);
//        }else{
//            if (pessoa.getIdResponsavel() == null && pessoa.getTipo() == TipoPessoa.FISICA){
//                throw new RuntimeException("Pessoas menores de idade precisam ter um responsável", null);
//            }else{
//                return pessoaRepository.save(pessoa);
//            }
//        }
//    }

    public Object salvar(PessoaPojo pessoa) {
        LocalDate maioridade = LocalDate.now();
                //LocalDate.parse("2002-10-30");
        maioridade.minusYears(18);

        if (pessoa.getTipo().equals(TipoPessoa.FISICA)){
            if (maioridade.isAfter(pessoa.getDataNascimento())) {//maior de idade
                return pessoaFisicaRepository.save(pessoa.gerarFisica(pessoa));
            }else if (pessoa.getIdResponsavel() == null){
                throw new RuntimeException("Pessoas menores de idade precisam ter um responsável", null);
            }else{
                return pessoaFisicaRepository.save(pessoa.gerarFisica(pessoa));
            }
        }else{
            return pessoaJuridicaRepository.save(pessoa.gerarJuridica(pessoa));
        }

//        if (maioridade.isAfter(pessoa.getDataNascimento())) {//maior de idade
//
//            //return pessoaRepository.save(pessoa);
//        }else{
//            if (pessoa.getIdResponsavel() == null && pessoa.getTipo() == TipoPessoa.FISICA){
//                throw new RuntimeException("Pessoas menores de idade precisam ter um responsável", null);
//            }else{
//                //return pessoaRepository.save(pessoa);
//            }
//        }
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
