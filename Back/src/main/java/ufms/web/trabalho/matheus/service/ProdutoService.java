package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.dto.ProdutoFisicoDTO;
import ufms.web.trabalho.matheus.dto.ProdutoJuridicoDTO;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public List<?> buscarStreamJuridico(String descricao, String precoMinimo, String precoMaximo, List<ProdutoJuridicoDTO> lista){
        Stream<?> busca = lista.stream()
                .filter(produto -> {
                    if (Objects.nonNull(precoMaximo)){
                        return produto.getPrecoVenda().compareTo(new BigDecimal(precoMaximo)) <= 0;
                    }else { return true; }
                }).filter(produto -> {
                    if (Objects.nonNull(precoMinimo)){
                        return produto.getPrecoVenda().compareTo(new BigDecimal(precoMinimo)) >= 0;
                    }else { return true; }
                }).filter(produto -> {
                    if (Objects.nonNull(descricao)){
                        return produto.getDescricao().equals(descricao);
                    }else { return true; }
                }).sorted(Comparator.comparing(ProdutoJuridicoDTO::getId));
        return busca.collect(Collectors.toList());
    }

    public List<?> buscarStreamFisico(String descricao, String precoMinimo, String precoMaximo, List<ProdutoFisicoDTO> lista){
        Stream<?> busca = lista.stream()
                .filter(produto -> {
                    if (Objects.nonNull(precoMaximo)){
                        return produto.getPrecoVenda().compareTo(new BigDecimal(precoMaximo)) <= 0;
                    }else { return true; }
                }).filter(produto -> {
                    if (Objects.nonNull(precoMinimo)){
                        return produto.getPrecoVenda().compareTo(new BigDecimal(precoMinimo)) >= 0;
                    }else { return true; }
                }).filter(produto -> {
                    if (Objects.nonNull(descricao)){
                        return produto.getDescricao().equals(descricao);
                    }else { return true; }
                }).sorted(Comparator.comparing(ProdutoFisicoDTO::getId));
        return busca.collect(Collectors.toList());
    }

//    public List<?> buscarStream(String descricao, String precoMinimo, String precoMaximo, Usuario comprador, List<Produto> lista){
//        Stream<?> busca;
//        if (comprador.getPessoa().getTipo().equals(TipoPessoa.FISICA)) {
//            busca = lista.stream()
//                    .filter(produto -> {
//                        if (Objects.nonNull(precoMaximo)){
//                            return produto.getPrecoVendaFisica().compareTo(new BigDecimal(precoMaximo)) <= 0;
//                        }else { return true; }
//                    })
//                    .filter(produto -> {
//                        if (Objects.nonNull(precoMinimo)){
//                            return produto.getPrecoVendaFisica().compareTo(new BigDecimal(precoMinimo)) >= 0;
//                        }else { return true; }
//                    })
//                    .filter(produto -> {
//                        if (Objects.nonNull(descricao)){
//                            return produto.getDescricao().equals(descricao);
//                        }else { return true; }
//                    })
//                    .map(produto -> ProdutoFisicoDTO.transformaEmDTO(produto));
//                    //.sorted(Comparator.comparing(ProdutoFisicoDTO::getId));
//        }else{
//            busca = lista.stream()
//                    .filter(produto -> {
//                        if (Objects.nonNull(precoMaximo)){
//                            return produto.getPrecoVendaJuridica().compareTo(new BigDecimal(precoMaximo)) <= 0;
//                        }else { return true; }
//                    }).filter(produto -> {
//                        if (Objects.nonNull(precoMinimo)){
//                            return produto.getPrecoVendaJuridica().compareTo(new BigDecimal(precoMinimo)) >= 0;
//                        }else { return true; }
//                    }).filter(produto -> {
//                        if (Objects.nonNull(descricao)){
//                            return produto.getDescricao().equals(descricao);
//                        }else { return true; }
//                    }).map(ProdutoJuridicoDTO::transformaEmDTO);
//                    //.sorted(Comparator.comparing(ProdutoJuridicoDTO::getId));
//        }
//        return busca.collect(Collectors.toList());
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
