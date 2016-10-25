
package telas.disciplina;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Disciplinas;

/**
 *
 * @author Alecsander
 */
public class ConsultaDisciplinasTableModel extends AbstractTableModel{
    
    private List<Disciplinas> listaDisciplina;
    private String[] colunas = {"Nome","Curso"};
    
    public ConsultaDisciplinasTableModel(List<Disciplinas> listaDisciplina){
        this.listaDisciplina = listaDisciplina;
    }

    @Override
    public int getRowCount() {
       return listaDisciplina.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaDisciplina.get(rowIndex).getNome();
        }else return listaDisciplina.get(rowIndex).getCursos().getNome();
        
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
