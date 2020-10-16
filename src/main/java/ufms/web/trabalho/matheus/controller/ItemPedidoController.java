package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.ItemPedido;
import ufms.web.trabalho.matheus.entity.Pedido;
import ufms.web.trabalho.matheus.service.ItemPedidoService;
import ufms.web.trabalho.matheus.service.PedidoService;

@Controller
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id){
        return new ResponseEntity(itemPedidoService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(){
        return new ResponseEntity(itemPedidoService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody ItemPedido usuario){
        return new ResponseEntity(itemPedidoService.salvar(usuario), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        itemPedidoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody ItemPedido usuario){
        return new ResponseEntity( itemPedidoService.alterar(id, usuario), HttpStatus.NO_CONTENT);
    }
}
