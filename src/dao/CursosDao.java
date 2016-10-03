/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cursos;
import Singleton.ConexaoSingleton;
import model.view.ViewCursos;

/**
 *
 * @author Wolverine
 */
public class CursosDao {

    private EntityManager manager;

    public Cursos salvar(Cursos cursos) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        cursos = manager.merge(cursos);
        //fechando uma transação
        manager.getTransaction().commit();
        return cursos;
    }

    public List<Cursos> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<Cursos> listaCursos = q.getResultList();
        manager.getTransaction().commit();
        return listaCursos;
    }

    public Cursos consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Cursos) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Cursos cursos = manager.find(Cursos.class, id);
        manager.remove(cursos);
        //fechando uma transação
        manager.getTransaction().commit();
    }
}
