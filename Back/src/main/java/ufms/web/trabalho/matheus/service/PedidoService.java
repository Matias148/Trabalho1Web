package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Pedido;
import ufms.web.trabalho.matheus.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> buscarTodos(){
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido Pedido){
        return pedidoRepository.save(Pedido);
    }

    public Optional<Pedido> buscarId(Long id){
        return pedidoRepository.findById(id);
    }

    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }

    public Pedido alterar(Long id, Pedido usuario){
        return pedidoRepository.save(usuario);
    }
}
