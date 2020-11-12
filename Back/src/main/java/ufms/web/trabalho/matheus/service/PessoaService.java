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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        LocalDate maioridade = LocalDate.parse("2002-10-30");

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

    public Stream<?> buscaStream(String idResponsavel, String nomeResponsavel, String tipo,
                            String situacao){
        //preciso implemnetar bisca por nome
        Stream<?> busca;
        if (tipo.equals(TipoPessoa.FISICA)){
            busca = pessoaFisicaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getIdResponsavel().equals(idResponsavel))
                    .filter(pessoa -> pessoa.getTipo().equals(TipoPessoa.FISICA))
                    .filter(pessoa -> pessoa.getSituacao().equals(situacao))
                    .sorted(Comparator.comparing(Pessoa::getId))
                    .map(Pessoa::getNome);
        }else{
            busca = pessoaJuridicaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getTipo().equals(TipoPessoa.JURIDICA))
                    .filter(pessoa -> pessoa.getSituacao().equals(situacao))
                    .sorted(Comparator.comparing(Pessoa::getId))
                    .map(Pessoa::getNome);
        }
        return busca;
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
