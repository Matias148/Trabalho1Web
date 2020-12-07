package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ufms.web.trabalho.matheus.dto.ProdutoFisicoDTO;
import ufms.web.trabalho.matheus.dto.ProdutoJuridicoDTO;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.enumeration.TipoPessoa;
import ufms.web.trabalho.matheus.service.LoginService;
import ufms.web.trabalho.matheus.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Usuario comprador = loginService.login(usuario, senha, 1);
        Optional<Produto> produto = produtoService.buscarId(id);
        Produto teste = produto.orElse(null);
        if (teste != null) {
            if (comprador.getPessoa().getTipo().equals(TipoPessoa.FISICA)) {
                ProdutoFisicoDTO fisico = ProdutoFisicoDTO.transformaEmDTO(teste);
                return new ResponseEntity(fisico, HttpStatus.OK);
            }else {
                ProdutoJuridicoDTO juridico = ProdutoJuridicoDTO.transformaEmDTO(teste);
                return new ResponseEntity(juridico, HttpStatus.OK);
            }
        }
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarStream(@RequestHeader("usuario") String usuario,
                                          @RequestHeader("senha") String senha,
                                          @RequestParam(value = "descricao", required = false) String descricao,
                                          @RequestParam(value = "precoMinimo", required = false) String precoMinimo,
                                          @RequestParam(value = "precoMaximo", required = false) String precoMaximo){
        Usuario comprador = loginService.login(usuario, senha, 1);
        //List lista = new ArrayList<>();
        List<Produto> todosFiltroIdade = loginService.retornaProdutosIdade(produtoService.buscarTodos(), comprador);
        if (comprador.getPessoa().getTipo().equals(TipoPessoa.FISICA)){
            List<ProdutoFisicoDTO> lista = new ArrayList<>();
            for (Produto produto: todosFiltroIdade) {
                lista.add(ProdutoFisicoDTO.transformaEmDTO(produto));
            }
            return new ResponseEntity(produtoService.buscarStreamFisico(descricao, precoMinimo, precoMaximo, lista)
                    , HttpStatus.OK);
        }else{
            List<ProdutoJuridicoDTO> lista = new ArrayList<>();
            for (Produto produto: todosFiltroIdade) {
                lista.add(ProdutoJuridicoDTO.transformaEmDTO(produto));
            }
            return new ResponseEntity(produtoService.buscarStreamJuridico(descricao, precoMinimo, precoMaximo, lista)
                    , HttpStatus.OK);
        }

    }

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<?> buscar(@RequestHeader("usuario") String usuario,
//                                    @RequestHeader("senha") String senha){
//        Usuario comprador = loginService.login(usuario, senha,1);
//        List<Produto> todosFiltroIdade = loginService.retornaProdutosIdade(produtoService.buscarTodos(), comprador);
//        if (comprador.getPessoa().getTipo().equals(TipoPessoa.FISICA)){
//            List<ProdutoFisicoDTO> lista = new ArrayList<>();
//            for (Produto produto: todosFiltroIdade) {
//                lista.add(ProdutoFisicoDTO.transformaEmDTO(produto));
//            }
//            return new ResponseEntity(lista, HttpStatus.OK);
//        }else{
//            List<ProdutoJuridicoDTO> lista = new ArrayList<>();
//            for (Produto produto: todosFiltroIdade) {
//                lista.add(ProdutoJuridicoDTO.transformaEmDTO(produto));
//            }
//            return new ResponseEntity(lista, HttpStatus.OK);
//        }
//    }

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
