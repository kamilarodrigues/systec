/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.UsuarioFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import model.view.ViewUsuario;

/**
 *
 * @author Wolverine
 */
public class UsuarioController {
    
    UsuarioFacade usuarioFacade;
    
    public Usuario salvar(Usuario usuario) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.salvar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar usuario " + ex);
            return null;
        }
    }
    
    public List<ViewUsuario> listar(String sql) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar usuario " + ex);
            return null;
        }
    }
    
    public Usuario consultar(String sql) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar usuario " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        usuarioFacade = new UsuarioFacade();
        try {
            usuarioFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir uma Turmas " + ex); 
        }
    }
    
    public Usuario consultar(String login, String senha) {
        usuarioFacade = new UsuarioFacade();
        try {
            return usuarioFacade.consultar(login, senha);
       } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro validar usuario " + ex);
            return null;
        }
    }
}
