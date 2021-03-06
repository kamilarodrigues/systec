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
import model.Turmas; 
import model.view.ViewTurmas;

/**
 *
 * @author Wolverine
 */
public class TurmasDao {

    private EntityManager manager;

    public Turmas salvar(Turmas turmas) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        turmas = manager.merge(turmas);
        //fechando uma transação
        manager.getTransaction().commit();
        return turmas;
    }

    public List<Turmas> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Turmas> listaTurmas = q.getResultList();
        manager.getTransaction().commit();
        return listaTurmas;
    }

    public Turmas consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Turmas) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Turmas turmas = manager.find(Turmas.class, id);
        manager.remove(turmas);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
