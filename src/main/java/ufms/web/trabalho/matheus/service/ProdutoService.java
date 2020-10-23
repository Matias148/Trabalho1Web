package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

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
