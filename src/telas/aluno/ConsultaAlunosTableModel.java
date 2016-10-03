/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.aluno;
 
import java.util.List;
import javax.swing.table.AbstractTableModel; 
import model.Matriculas;

/**
 *
 * @author Wolverine
 */
public class ConsultaAlunosTableModel extends AbstractTableModel{
    
    private List<Matriculas> listaAlunos;
    private String[] colunas ={"Matricula", "Nome", "Turma"};

    public ConsultaAlunosTableModel(List<Matriculas> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @Override
    public int getRowCount() {
        return listaAlunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaAlunos.get(rowIndex).getMatricula();
        }if (columnIndex==1){
            return listaAlunos.get(rowIndex).getAlunosId();
        }else return listaAlunos.get(rowIndex).getTurmasId();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
            return String.class;
        }else if (columnIndex==1){
             return String.class; 
         }else return String.class;
    } 
}
