/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.DisciplinasDao;
import java.sql.SQLException;
import java.util.List;
import model.Disciplinas;
import model.view.ViewDisciplina;

/**
 *
 * @author Wolverine
 */
public class DisciplinaFacade {
    
    DisciplinasDao disciplinasDao;
    
    public Disciplinas salvar(Disciplinas disciplinas) throws SQLException{
        disciplinasDao = new DisciplinasDao();
        return disciplinasDao.salvar(disciplinas);
    }
    
    public List<ViewDisciplina> listar(String sql) throws SQLException{
        disciplinasDao = new DisciplinasDao();
        return disciplinasDao.listar(sql);
    }
    
    public Disciplinas consultar(String sql) throws SQLException{
        disciplinasDao = new DisciplinasDao();
        return disciplinasDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        disciplinasDao = new DisciplinasDao();
        disciplinasDao.excluir(id);
    }
}
