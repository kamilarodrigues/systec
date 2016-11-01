/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.MatriculasFacade;
import facade.MovimentoAcademicoFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Matriculas;
import model.MovimentosAcademicos;
import model.view.ViewMatriculas;
import model.view.ViewMovimentoAcademicos;

/**
 *
 * @author Wolverine
 */
public class MovimentoAcademicoController {
    
    MovimentoAcademicoFacade movimentoAcademicoFacade;
    
    public MovimentosAcademicos salvar(MovimentosAcademicos movimento) {
        
        movimentoAcademicoFacade = new MovimentoAcademicoFacade();
        try {
            return movimentoAcademicoFacade.salvar(movimento);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro salvar o movimento academico " + ex);
            return null;
        }
    }
    
    public List<MovimentosAcademicos> listar(String sql) {
        movimentoAcademicoFacade = new MovimentoAcademicoFacade();
        try {
            return movimentoAcademicoFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Matriculas " + ex);
            return null;
        }
    }
    
//    public Matriculas consultar(String sql) {
//        matriculasFacade = new MatriculasFacade();
//        try {
//            return matriculasFacade.consultar(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Erro Consultar Matriculas " + ex);
//            return null;
//        }
//    }
    
//    public void excluir(int id){
//        matriculasFacade = new MatriculasFacade();
//        try {
//            matriculasFacade.excluir(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Erro excluir Matriculas " + ex); 
//        }
//    }
    
}
