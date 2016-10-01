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
import model.Matriculas;
import model.view.ViewMatriculas;

/**
 *
 * @author Wolverine
 */
public class MatriculasDao {

    private EntityManager manager;

    public Matriculas salvar(Matriculas matriculas) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        matriculas = manager.merge(matriculas);
        //fechando uma transação
        manager.getTransaction().commit();
        return matriculas;
    }

    public List<ViewMatriculas> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<ViewMatriculas> listaMatriculas = q.getResultList();
        manager.getTransaction().commit();
        return listaMatriculas;
    }

    public Matriculas consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Matriculas) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Matriculas matriculas = manager.find(Matriculas.class, id);
        manager.remove(matriculas);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
