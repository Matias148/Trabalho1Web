package ufms.web.trabalho.matheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufms.web.trabalho.matheus.entity.Usuario;
import ufms.web.trabalho.matheus.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarId(Long id){
        return usuarioRepository.findById(id);
    }

    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario alterar(Long id, Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
