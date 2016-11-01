/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query; 
import Singleton.ConexaoSingleton;   
import model.MovimentosAcademicos;
import model.view.ViewMovimentoAcademicos;

/**
 *
 * @author Wolverine
 */
public class MovimentoAcademicoDao {

    private EntityManager manager; 

    public MovimentosAcademicos salvar(MovimentosAcademicos movimentosAcademicos) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        movimentosAcademicos = manager.merge(movimentosAcademicos);
        //fechando uma transação
        manager.getTransaction().commit();
        return movimentosAcademicos;
    }

    public List<MovimentosAcademicos> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<MovimentosAcademicos> listaMovimentoAcademico = q.getResultList();
        manager.getTransaction().commit();
        return listaMovimentoAcademico;
    }

    public MovimentosAcademicos consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (MovimentosAcademicos) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        MovimentosAcademicos movimentosAcademicos = manager.find(MovimentosAcademicos.class, id);
        manager.remove(movimentosAcademicos);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
