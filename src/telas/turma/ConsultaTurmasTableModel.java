/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.turma;
 
import java.util.List;
import javax.swing.table.AbstractTableModel; 
import model.Turmas;

/**
 *
 * @author Krystian
 */

public class ConsultaTurmasTableModel extends AbstractTableModel{
    
    private List<Turmas> listaTurmas;
    private String[] colunas ={"Código", "Curso"};

    public ConsultaTurmasTableModel(List<Turmas> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    @Override
    public int getRowCount() {
        return listaTurmas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaTurmas.get(rowIndex).getCodigo();
        }else return listaTurmas.get(rowIndex).getCursosId().getNome();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
            return String.class;
        }else return String.class;
    } 
}
