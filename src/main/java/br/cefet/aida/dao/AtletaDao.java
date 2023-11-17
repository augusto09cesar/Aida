/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.aida.dao;

import br.cefet.aida.model.Atleta;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author dougl
 */
@RegisterBeanMapper(Atleta.class)
public interface AtletaDao {

    @GetGeneratedKeys
    @SqlUpdate("insert into atleta (idAtleta, nome, email, cpf, turma, curso) values (:idAtleta, :nome, :email, :cpf, :turma, :curso)")
    int insert(@BindBean Atleta atleta);

    @SqlQuery("select * from atleta where idAtleta = :idAtleta;")
    Atleta get(@Bind("idAtleta") int idAtleta);

    @SqlQuery("select * from atleta order by nome;")
    List<Atleta> getAll();

    @SqlQuery("select * from atleta where nome like :nome order by nome;")
    List<Atleta> getAllByName(@Bind("nome") String nome);

    @SqlUpdate("update atleta set nome = :nome, email = :email, cpf = :cpf, turma = :turma, curso = :curso where idAtleta = :idAtleta;")
    int update(@BindBean Atleta atleta);

    @SqlUpdate("delete from atleta where idAtleta = :idAtleta;")
    int delete(@Bind("idAtleta") int idAtleta);
}
