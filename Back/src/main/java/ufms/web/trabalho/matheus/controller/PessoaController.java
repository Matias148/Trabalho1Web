package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.Pessoa;
import ufms.web.trabalho.matheus.pojo.PessoaPojo;
import ufms.web.trabalho.matheus.service.LoginService;
import ufms.web.trabalho.matheus.service.PessoaService;

@Controller
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private LoginService loginService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id,
                                      @RequestHeader("usuario") String usuario,
                                      @RequestHeader("senha") String senha){
        loginService.login(usuario, senha);
        return new ResponseEntity(pessoaService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(//@RequestHeader("usuario") String usuario,
                                    //@RequestHeader("senha") String senha
    ){
        //loginService.login(usuario, senha);
        return new ResponseEntity(pessoaService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody PessoaPojo pessoa){
        //loginService.loginAdm(usuario, senha);
        //se precisar de login para criar uma pessoa, nao dá para criar um usuário, então não se cria nada
        return new ResponseEntity(pessoaService.salvar(pessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id,
                                     @RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha){
        loginService.loginAdm(usuario, senha);
        pessoaService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Pessoa pessoa,
                                     @RequestHeader("usuario") String usuario,
                                     @RequestHeader("senha") String senha){
        loginService.loginAdm(usuario, senha);
        return new ResponseEntity( pessoaService.alterar(id, pessoa), HttpStatus.NO_CONTENT);
    }
}
