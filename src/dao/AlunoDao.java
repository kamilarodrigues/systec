/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Alunos; 
import Singleton.ConexaoSingleton;
import model.view.ViewAlunos;

/**
 *
 * @author Wolverine
 */
public class AlunoDao {
    
    private EntityManager manager;
    
    public Alunos salvar(Alunos alunos) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        alunos = manager.merge(alunos);
        //fechando uma transação
        manager.getTransaction().commit();
        return alunos;
    }
    
    public List<ViewAlunos> listar(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<ViewAlunos> listaAlunos = q.getResultList();
         manager.getTransaction().commit();
        return listaAlunos;
    }
    
    public Alunos consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Alunos) q.getResultList().get(0);
        } else {
            return null;
        }
    }
    
    
    public void excluir(int id) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Alunos alunos = manager.find(Alunos.class, id);
        manager.remove(alunos);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
