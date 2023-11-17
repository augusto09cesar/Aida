/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.aida.service;

import br.cefet.aida.dao.AtletaDao;
import br.cefet.aida.model.Atleta;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

/**
 *
 * @author dougl
 */
@Service
public class AtletaService { // Updated class name
    
    private final AtletaDao atletaDao; // Updated variable name
    
    public AtletaService(Jdbi jdbi){
        this.atletaDao = jdbi.onDemand(AtletaDao.class); // Updated variable name
    }
    
    public Atleta inserir (Atleta atleta){ // Updated parameter type and variable name
        int idAtleta = atletaDao.insert(atleta); // Updated variable name
        atleta.setIdAtleta(idAtleta); // Updated variable name
        return atleta; // Updated variable name
    }
    
    public List<Atleta> consultarTodos(){ // Updated return type
        return atletaDao.getAll(); // Updated method name
    }
    
    public Atleta consultarPorId(int idAtleta){ // Updated parameter type
        return atletaDao.get(idAtleta); // Updated method name
    }
    
    public void alterar(Atleta atleta){ // Updated parameter type and variable name
        atletaDao.update(atleta); // Updated variable name
    }
    
    public void excluir(int idAtleta){ // Updated parameter type
        atletaDao.delete(idAtleta); // Updated variable name
    }
}
