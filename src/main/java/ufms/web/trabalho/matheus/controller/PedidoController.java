package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.Pedido;
import ufms.web.trabalho.matheus.service.PedidoService;

@Controller
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id){
        return new ResponseEntity(pedidoService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(){
        return new ResponseEntity(pedidoService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody Pedido usuario){
        return new ResponseEntity(pedidoService.salvar(usuario), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        pedidoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Pedido usuario){
        return new ResponseEntity( pedidoService.alterar(id, usuario), HttpStatus.NO_CONTENT);
    }
}
