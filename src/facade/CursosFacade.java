/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CursosDao;
import java.sql.SQLException;
import java.util.List;
import model.Cursos;
import model.view.ViewCursos;

/**
 *
 * @author Wolverine
 */
public class CursosFacade {
    
    CursosDao cursosDao;
    
    public Cursos salvar(Cursos cursos) throws SQLException{
        cursosDao = new CursosDao();
        return cursosDao.salvar(cursos);
    }
    
    public List<ViewCursos> listar(String sql) throws SQLException{
        cursosDao = new CursosDao();
        return cursosDao.listar(sql);
    }
    
    public Cursos consultar(String sql) throws SQLException{
        cursosDao = new CursosDao();
        return cursosDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        cursosDao = new CursosDao();
        cursosDao.excluir(id);
    }
}
