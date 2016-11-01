/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.MovimentoAcademicoDao;
import java.sql.SQLException;
import java.util.List;
import model.MovimentosAcademicos;
import model.view.ViewMovimentoAcademicos;

/**
 *
 * @author Wolverine
 */
public class MovimentoAcademicoFacade {
    
    MovimentoAcademicoDao movimentoAcademicoDao;
    
    public MovimentosAcademicos salvar(MovimentosAcademicos movimentosAcademicos) throws SQLException{
        movimentoAcademicoDao = new MovimentoAcademicoDao();
        return movimentoAcademicoDao.salvar(movimentosAcademicos);
    }
    
    public List<MovimentosAcademicos> listar(String sql) throws SQLException{
        movimentoAcademicoDao = new MovimentoAcademicoDao();
        return movimentoAcademicoDao.listar(sql);
    }
    
    public MovimentosAcademicos consultar(String sql) throws SQLException{
        movimentoAcademicoDao = new MovimentoAcademicoDao();
        return movimentoAcademicoDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        movimentoAcademicoDao = new MovimentoAcademicoDao();
        movimentoAcademicoDao.excluir(id);
    }
}
