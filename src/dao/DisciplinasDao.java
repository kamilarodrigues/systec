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
import model.Disciplinas;
import model.view.ViewDisciplina;

/**
 *
 * @author Wolverine
 */
public class DisciplinasDao {

    private EntityManager manager;

    public Disciplinas salvar(Disciplinas disciplinas) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        disciplinas = manager.merge(disciplinas);
        //fechando uma transação
        manager.getTransaction().commit();
        return disciplinas;
    }

    public List<ViewDisciplina> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<ViewDisciplina> listaDisciplina = q.getResultList();
        manager.getTransaction().commit();
        return listaDisciplina;
    }

     public Disciplinas consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Disciplinas) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Disciplinas disciplinas = manager.find(Disciplinas.class, id);
        manager.remove(disciplinas);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
