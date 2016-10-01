/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.AlunoDao;
import java.sql.SQLException;
import java.util.List;
import model.Alunos;
import model.view.ViewAlunos;

/**
 *
 * @author Wolverine
 */
public class AlunosFacade {
    
    AlunoDao alunoDao;
    
    public Alunos salvar(Alunos alunos) throws SQLException{
        alunoDao = new AlunoDao();
        return alunoDao.salvar(alunos);
    }
    
    public List<ViewAlunos> listar(String sql) throws SQLException{
        alunoDao = new AlunoDao();
        return alunoDao.listar(sql);
    }
    
    public Alunos consultar(String sql) throws SQLException{
        alunoDao = new AlunoDao();
        return alunoDao.consultar(sql);
    }
    
     public void excluir(int id) throws SQLException{
        alunoDao = new AlunoDao();
        alunoDao.excluir(id);
    }
}
