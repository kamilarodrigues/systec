/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.DisciplinaFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Disciplinas;
import model.view.ViewDisciplina;

/**
 *
 * @author Wolverine
 */
public class DisciplinaController {
    
    DisciplinaFacade disciplinaFacade;
    
    public Disciplinas salvar(Disciplinas disciplinas) {
        disciplinaFacade = new DisciplinaFacade();
        try {
            return disciplinaFacade.salvar(disciplinas);
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Disciplinas " + ex);
            return null;
        }
    }
    
    public List<Disciplinas> listar(String sql) {
        disciplinaFacade = new DisciplinaFacade();
        try {
            return disciplinaFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Disciplinas " + ex);
            return null;
        }
    }
    
    public Disciplinas consultar(String sql) {
        disciplinaFacade = new DisciplinaFacade();
        try {
            return disciplinaFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Disciplinas " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        disciplinaFacade = new DisciplinaFacade();
        try {
            disciplinaFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir uma Disciplinas " + ex); 
        }
    }
    
}
