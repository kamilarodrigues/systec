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
import model.Usuario;
import model.view.ViewUsuario;

/**
 *
 * @author Wolverine
 */
public class UsuarioDao {

    private EntityManager manager;

    public Usuario salvar(Usuario usuario) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        usuario = manager.merge(usuario);
        //fechando uma transação
        manager.getTransaction().commit();
        return usuario;
    }

    public List<ViewUsuario> listar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        List<ViewUsuario> listaUsuario = q.getResultList();
        manager.getTransaction().commit();
        return listaUsuario;
    }

    public Usuario consultar(String sql) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery(sql);
        manager.getTransaction().commit();
        if (q.getResultList().size() > 0) {
            return (Usuario) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void excluir(int id) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        Usuario usuario = manager.find(Usuario.class, id);
        manager.remove(usuario);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public Usuario consultar(String login, String senha) throws SQLException{
        manager = ConexaoSingleton.getConexao();
         manager.getTransaction().begin();
        Query q = manager.createQuery("select u from Usuario u where u.usuario='" + login + "' and u.senha='" + senha + "'  order by u.nome");
        manager.getTransaction().commit();
        if (q.getResultList().size()>0){
            return (Usuario) q.getResultList().get(0);
        }
        return null;
    }
}
