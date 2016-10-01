/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.TurmasFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Turmas;
import model.view.ViewTurmas;

/**
 *
 * @author Wolverine
 */
public class TurmaController {
    
    TurmasFacade turmasFacade;
    
    public Turmas salvar(Turmas turmas) {
        turmasFacade = new TurmasFacade();
        try {
            return turmasFacade.salvar(turmas);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Turmas " + ex);
            return null;
        }
    }
    
    public List<ViewTurmas> listar(String sql) {
        turmasFacade = new TurmasFacade();
        try {
            return turmasFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Turmas " + ex);
            return null;
        }
    }
    
    public Turmas consultar(String sql) {
        turmasFacade = new TurmasFacade();
        try {
            return turmasFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Turmas " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        turmasFacade = new TurmasFacade();
        try {
            turmasFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(TurmaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir uma Turmas " + ex); 
        }
    }
    
}
