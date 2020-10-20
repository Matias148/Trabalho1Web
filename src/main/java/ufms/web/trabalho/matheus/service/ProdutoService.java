package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

//    public List<Produto> buscarTodos(Usuario comprador){
//        int idade;
//        LocalDate agora = LocalDate.now();
//        LocalDate nascimento = comprador.getPessoa().getDataNascimento();
//
//        idade = agora.getYear() - nascimento.getYear();
//
//        return produtoRepository.consultaComIdade((long)idade);
//    }

    public Produto salvar(Produto Pedido){
        return produtoRepository.save(Pedido);
    }

    public Optional<Produto> buscarId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto alterar(Long id, Produto usuario){
        return produtoRepository.save(usuario);
    }
}
