package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Stream<?> buscarStream(String descricao, String precoMinimo, String precoMaximo, Usuario comprador, List<Produto> lista){

        Stream<?> busca;
        if (comprador.getPessoa().getTipo().equals(TipoPessoa.FISICA)) {
            busca = lista.stream()
                    .filter(produto -> produto.getPrecoVendaFisica().compareTo(new BigDecimal(precoMaximo)) <= 0)
                    .filter(produto -> produto.getPrecoVendaFisica().compareTo(new BigDecimal(precoMinimo)) >= 0)
                    .filter(produto -> produto.getDescricao().equals(descricao))
                    .sorted(Comparator.comparing(Produto::getId))
                    .map(Produto::getDescricao);
        }else{
            busca = lista.stream()
                    .filter(produto -> produto.getPrecoVendaJuridica().compareTo(new BigDecimal(precoMaximo)) <= 0)
                    .filter(produto -> produto.getPrecoVendaJuridica().compareTo(new BigDecimal(precoMinimo)) >= 0)
                    .filter(produto -> produto.getDescricao().equals(descricao))
                    .sorted(Comparator.comparing(Produto::getId))
                    .map(Produto::getDescricao);
        }
        return busca;
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
