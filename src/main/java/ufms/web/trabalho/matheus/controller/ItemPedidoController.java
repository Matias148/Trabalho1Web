package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.ItemPedido;
import ufms.web.trabalho.matheus.entity.Pedido;
import ufms.web.trabalho.matheus.service.ItemPedidoService;
import ufms.web.trabalho.matheus.service.LoginService;
import ufms.web.trabalho.matheus.service.PedidoService;

@Controller
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private LoginService loginService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id,
                                      @RequestHeader("usuario") String usuario,
                                      @RequestHeader("senha") String senha){
        loginService.login(usuario, senha);
        return new ResponseEntity(itemPedidoService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(@RequestHeader("usuario") String usuario,
                                    @RequestHeader("senha") String senha){
        loginService.login(usuario, senha);
        return new ResponseEntity(itemPedidoService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("usuario") String usuario,
                                    @RequestHeader("senha") String senha,
                                    @RequestBody ItemPedido itemPedido){
        loginService.loginAdm(usuario, senha);
        return new ResponseEntity(itemPedidoService.salvar(itemPedido), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha,
                                     @PathVariable("id") Long id){
        loginService.loginAdm(usuario, senha);
        itemPedidoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha,
                                     @PathVariable("id") Long id,
                                     @RequestBody ItemPedido itemPedido){
        loginService.loginAdm(usuario, senha);
        return new ResponseEntity( itemPedidoService.alterar(id, itemPedido), HttpStatus.NO_CONTENT);
    }
}
