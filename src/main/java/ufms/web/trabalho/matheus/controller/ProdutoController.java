package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.service.LoginService;
import ufms.web.trabalho.matheus.service.ProdutoService;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private LoginService loginService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id,
                                      @RequestHeader("usuario") String usuario,
                                      @RequestHeader("senha") String senha){
        loginService.login(usuario, senha);
        return new ResponseEntity(produtoService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(
            @RequestHeader("usuario") String usuario,
            @RequestHeader("senha") String senha){
        Usuario comprador = loginService.login(usuario, senha,1);
//        return new ResponseEntity(produtoService.buscarTodos(comprador), HttpStatus.OK);
        return new ResponseEntity(loginService.retornaProdutosIdade(produtoService.buscarTodos(), comprador), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody Produto produto,
                                    @RequestHeader("usuario") String usuario,
                                    @RequestHeader("senha") String senha){
        loginService.loginAdm(usuario, senha);
        return new ResponseEntity(produtoService.salvar(produto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id,
                                     @RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha){
        loginService.loginAdm(usuario, senha);
        produtoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Produto produto,
                                     @RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha){
        loginService.loginAdm(usuario, senha);
        return new ResponseEntity( produtoService.alterar(id, produto), HttpStatus.NO_CONTENT);
    }
}
