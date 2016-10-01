/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import model.Usuario;
import model.view.ViewUsuario;

/**
 *
 * @author Wolverine
 */
public class UsuarioFacade {
    
    UsuarioDao usuarioDao;
    
    public Usuario salvar(Usuario usuario) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.salvar(usuario);
    }
    
    public List<ViewUsuario> listar(String sql) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.listar(sql);
    }
    
    public Usuario consultar(String sql) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        usuarioDao = new UsuarioDao();
        usuarioDao.excluir(id);
    }
     
     public Usuario consultar(String login, String senha) throws SQLException{
        usuarioDao = new UsuarioDao();
        return usuarioDao.consultar(login, senha);
    }
}
