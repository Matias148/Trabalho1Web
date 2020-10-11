package ufms.web.trabalho.matheus.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.ItemPedido;
import ufms.web.trabalho.matheus.repository.ItemPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> buscarTodos(){
        return itemPedidoRepository.findAll();
    }

    public ItemPedido salvar(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }

    public Optional<ItemPedido> buscarId(Long id){
        return itemPedidoRepository.findById(id);
    }

    public void deletar(Long id){
        itemPedidoRepository.deleteById(id);
    }

    public ItemPedido alterar(Long id, ItemPedido usuario){
        return itemPedidoRepository.save(usuario);
    }
}
