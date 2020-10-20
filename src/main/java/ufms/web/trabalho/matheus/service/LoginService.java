package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void login(String usuario, String senha){
        Usuario usuario1 = usuarioRepository.consultaSqlNomeSenha(usuario, senha);
        if (!usuario1.getLogin().equals(usuario) || !usuario1.getSenha().equals(senha)){
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }
    }

    public void loginAdm(String usuario, String senha){
        Usuario usuario1 = usuarioRepository.consultaSqlNomeSenha(usuario, senha);
        if (!usuario1.getLogin().equals(usuario) || !usuario1.getSenha().equals(senha) || !usuario1.isAdministrador()){
            throw new RuntimeException("Usuário ou senha incorretos", null);
        }
    }
}
