/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.MatriculasFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Matriculas;
import model.view.ViewMatriculas;

/**
 *
 * @author Wolverine
 */
public class MatriculaController {
    
    MatriculasFacade matriculasFacade;
    
    public Matriculas salvar(Matriculas matriculas) {
        matriculasFacade = new MatriculasFacade();
        try {
            return matriculasFacade.salvar(matriculas);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Matriculas " + ex);
            return null;
        }
    }
    
    public List<Matriculas> listar(String sql) {
        matriculasFacade = new MatriculasFacade();
        try {
            return matriculasFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Matriculas " + ex);
            return null;
        }
    }
    
    public Matriculas consultar(String sql) {
        matriculasFacade = new MatriculasFacade();
        try {
            return matriculasFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Matriculas " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        matriculasFacade = new MatriculasFacade();
        try {
            matriculasFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir Matriculas " + ex); 
        }
    }
    
}
