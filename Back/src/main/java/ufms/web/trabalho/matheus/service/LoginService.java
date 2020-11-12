package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Produto;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void login(String usuario, String senha){
        Usuario usuario1 = usuarioRepository.consultaHqlNomeSenha(usuario, senha);
        if (usuario1 == null)   {
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }
    }

    public Usuario login(String usuario, String senha, int controle){
        Usuario usuario1 = usuarioRepository.consultaHqlNomeSenha(usuario, senha);
        if (usuario1 == null){
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }else{
            return usuario1;
        }
    }

    public List<Produto> retornaProdutosIdade(List<Produto> lista, Usuario comprador){
        int idade;
        LocalDate agora = LocalDate.now();
        LocalDate nascimento = comprador.getPessoa().getDataNascimento();
        idade = agora.getYear() - nascimento.getYear();

        return  lista.stream().filter(produto -> produto.getIdadePermitida() <= idade).collect(Collectors.toList());
    }

    public void loginAdm(String usuario, String senha){
        Usuario usuario1 = usuarioRepository.consultaHqlNomeSenha(usuario, senha);
        if (usuario1 == null || !usuario1.getIsAdministrador()){
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }
    }
}
