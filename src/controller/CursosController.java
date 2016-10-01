/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.CursosFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cursos;
import model.view.ViewCursos;

/**
 *
 * @author Wolverine
 */
public class CursosController {
    
    CursosFacade cursosFacade;
    
    public Cursos salvar(Cursos cursos) {
        cursosFacade = new CursosFacade();
        try {
            return cursosFacade.salvar(cursos);
        } catch (SQLException ex) {
            Logger.getLogger(CursosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Salvar Cursos " + ex);
            return null;
        }
    }
    
    public List<ViewCursos> listar(String sql) {
        cursosFacade = new CursosFacade();
        try {
            return cursosFacade.listar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CursosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Listar Cursos " + ex);
            return null;
        }
    }
    
    public Cursos consultar(String sql) {
        cursosFacade = new CursosFacade();
        try {
            return cursosFacade.consultar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CursosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro Consultar Cursos " + ex);
            return null;
        }
    }
    
    public void excluir(int id){
        cursosFacade = new CursosFacade();
        try {
            cursosFacade.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(CursosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro excluir uma Cursos " + ex); 
        }
    }
    
}
