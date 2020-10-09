package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.service.UsuarioService;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> buscarId(@PathVariable("id") Long id){
        return new ResponseEntity(usuarioService.buscarId(id), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscar(){
        return new ResponseEntity(usuarioService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestBody Usuario usuario){
        return new ResponseEntity(usuarioService.salvar(usuario), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        usuarioService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@PathVariable("id") Long id,
                                     @RequestBody Usuario usuario){
        return new ResponseEntity( usuarioService.alterar(id, usuario), HttpStatus.NO_CONTENT);
    }
}
