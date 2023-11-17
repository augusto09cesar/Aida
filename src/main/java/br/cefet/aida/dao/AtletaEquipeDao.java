/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefet.aida.dao;
import br.cefet.aida.model.AtletaEquipe;

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
@RegisterBeanMapper(AtletaEquipe.class)
public interface AtletaEquipeDao {

    @GetGeneratedKeys
    @SqlUpdate("insert into Atleta_Equipe (idAtleta, idEquipe) values (:idAtleta, :idEquipe)")
    int insert(@BindBean AtletaEquipe atleta);

    @SqlQuery("select * from Atleta_Equipe where idAtletaEquipe = :idAtletaEquipe;")
    AtletaEquipe get(@Bind("idAtletaEquipe") int idAtletaEquipe);

    @SqlQuery("select * from Atleta_Equipe;")
    List<AtletaEquipe> getAll();

    @SqlQuery("select * from Atleta_Equipe where idEquipe = :idEquipe;")
    List<AtletaEquipe> getAllByEquipe(@Bind("idEquipe") int idEquipe);

    @SqlUpdate("update Atleta_Equipe set idEquipe = :idEquipe, idAtleta = :idAtleta where idAtletaEquipe = :idAtletaEquipe;")
    int update(@BindBean AtletaEquipe atletaEquipe);

    @SqlUpdate("delete from Atleta_Equipe where idAtletaEquipe = :idAtletaEquipe;")
    int delete(@Bind("idAtletaEquipe") int idAtletaEquipe);
}
