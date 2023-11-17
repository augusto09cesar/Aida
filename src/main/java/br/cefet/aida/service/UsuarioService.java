/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.aida.service;

import br.cefet.aida.dao.UsuarioDao;
import br.cefet.aida.model.Usuario;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

/**
 *
 * @author dougl
 */
@Service
public class UsuarioService {
    
    private final UsuarioDao usuarioDao;
    
    public UsuarioService(Jdbi jdbi){
        this.usuarioDao = jdbi.onDemand(UsuarioDao.class);
    }
    
    public Usuario inserir (Usuario usuario){
        int idUsuario = usuarioDao.insert(usuario);
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }
    
    public List<Usuario> consultarTodos(){
        return usuarioDao.getAll();
    }
    
    public Usuario consultarPorIdUsuario(int idUsuario){
        return usuarioDao.get(idUsuario);
    }
    
    public Usuario consultarPorEmail(String email){
        return usuarioDao.getbyemail(email);
    }
    
    public void alterar(Usuario usuario){
        usuarioDao.update(usuario);
    }
    
    public void excluir(int idUsuario){
        usuarioDao.delete(idUsuario);
    }
    
}
