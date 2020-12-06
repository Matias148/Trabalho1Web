package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Fisica;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.pojo.PessoaPojo;
import ufms.web.trabalho.matheus.repository.PessoaFisicaRepository;
import ufms.web.trabalho.matheus.repository.PessoaJuridicaRepository;
import ufms.web.trabalho.matheus.repository.PessoaRepository;

import javax.persistence.PessimisticLockException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Object salvar(PessoaPojo pessoa) {
        LocalDate maioridade = LocalDate.parse("2002-11-23");

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
    }

    public List<?> buscaStream(String idResponsavel, String nomeResponsavel, String tipo, String situacao){
        Stream<?> busca;
        if (TipoPessoa.FISICA.toString().equals(tipo)){
            busca = pessoaFisicaRepository.findAll().stream()
                    .filter(pessoa -> { if (Objects.nonNull(idResponsavel)) {
                                return pessoa.getIdResponsavel().getId().toString().equals(idResponsavel);
                            }else{ return true; } }
                    ).filter(pessoa -> pessoa.getTipo().equals(TipoPessoa.FISICA))
                    .filter(pessoa -> { if (Objects.nonNull(situacao)) {
                                return pessoa.getSituacao().toString().equals(situacao);
                            }else{ return true; } }
                    ).filter(pessoa ->{ if (Objects.nonNull(nomeResponsavel)){
                            return pessoa.getIdResponsavel().getNome().equals(nomeResponsavel);
                        }else { return true;} })
                    .sorted(Comparator.comparing(Pessoa::getId));
        }else if (TipoPessoa.JURIDICA.toString().equals(tipo)){
            busca = pessoaJuridicaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getTipo().equals(TipoPessoa.JURIDICA))
                    .filter(pessoa -> {if (Objects.nonNull(situacao)){
                                return pessoa.getSituacao().toString().equals(situacao);
                            }else { return true; } });
                    //.sorted(Comparator.comparing(Fisica::getId));
        }else{
            busca = pessoaRepository.findAll().stream()
                    .filter(pessoa -> { if (Objects.nonNull(situacao)) {
                                return pessoa.getSituacao().toString().equals(situacao);
                            }else{ return true; } }
                    ).filter(pessoa -> { if (Objects.nonNull(idResponsavel)) {
                                    return pessoa.getIdResponsavel().getId().toString().equals(idResponsavel);
                            }else{ return true; } }
                    ).filter(pessoa -> { if (Objects.nonNull(nomeResponsavel)){
                                return pessoa.getIdResponsavel().getNome().equals(nomeResponsavel);
                            }else { return true; } }
                    );//.sorted(Comparator.comparing(Pessoa::getId));
        }
        return busca.collect(Collectors.toList());
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
