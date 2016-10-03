/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TurmasDao;
import java.sql.SQLException;
import java.util.List;
import model.Turmas;
import model.view.ViewTurmas;

/**
 *
 * @author Wolverine
 */
public class TurmasFacade {
    
    TurmasDao turmasDao;
    
    public Turmas salvar(Turmas turmas) throws SQLException{
        turmasDao = new TurmasDao();
        return turmasDao.salvar(turmas);
    }
    
    public List<Turmas> listar(String sql) throws SQLException{
        turmasDao = new TurmasDao();
        return turmasDao.listar(sql);
    }
    
    public Turmas consultar(String sql) throws SQLException{
        turmasDao = new TurmasDao();
        return turmasDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        turmasDao = new TurmasDao();
        turmasDao.excluir(id);
    }
}
