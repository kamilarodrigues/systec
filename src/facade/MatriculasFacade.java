/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.MatriculasDao;
import java.sql.SQLException;
import java.util.List;
import model.Matriculas;
import model.view.ViewMatriculas;

/**
 *
 * @author Wolverine
 */
public class MatriculasFacade {
    
    MatriculasDao matriculasDao;
    
    public Matriculas salvar(Matriculas matriculas) throws SQLException{
        matriculasDao = new MatriculasDao();
        return matriculasDao.salvar(matriculas);
    }
    
    public List<ViewMatriculas> listar(String sql) throws SQLException{
        matriculasDao = new MatriculasDao();
        return matriculasDao.listar(sql);
    }
    
    public Matriculas consultar(String sql) throws SQLException{
        matriculasDao = new MatriculasDao();
        return matriculasDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        matriculasDao = new MatriculasDao();
        matriculasDao.excluir(id);
    }
}
