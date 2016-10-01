/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.AlunosFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Alunos;
import model.view.ViewAlunos;

/**
 *
 * @author Wolverine
 */
public class AlunosController {
    
    AlunosFacade alunosFacade;
    
    public Alunos salvar(Alunos alunos) {
        alunosFacade = new AlunosFacade();
        try {
            return alunosFacade.salvar(alunos);
        } catch (SQLException ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Alunos " + ex);
            return null;
        }
    }
    
    public List<ViewAlunos> listar(String sql) {
        alunosFacade = new AlunosFacade();
        try {
            return alunosFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Alunos " + ex);
            return null;
        }
    }
    
    public Alunos consultar(String sql) {
        alunosFacade = new AlunosFacade();
        try {
            return alunosFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Alunos " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        alunosFacade = new AlunosFacade();
        try {
            alunosFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(AlunosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir Alunos " + ex); 
        }
    }
    
}
