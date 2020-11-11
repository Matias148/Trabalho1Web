package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.enumeration.EGenero;
import ufms.web.trabalho.matheus.repository.LambdaRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LambdaService {
    @Autowired
    private LambdaRepository lambdaRepository;

    public List<Object> findAll() {
        Stream<String> teste = lambdaRepository.findAll()
                .stream()
                .filter(cliente -> cliente.getGenero().equals(EGenero.MASCULINO))
                .filter(cliente -> cliente.getIdade() <= 10)
                .sorted(Comparator.comparing(Pessoa::getId))
                .map(Pessoa::getNome);

        System.out.println("1");

        teste.forEach(System.out::println);
        return null;
//        return null;
    }
}
