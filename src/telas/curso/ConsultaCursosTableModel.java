package telas.curso;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cursos;
 
public class ConsultaCursosTableModel extends AbstractTableModel{
    
    private List<Cursos> listaCursos;
    private String[] colunas ={"Nome"};

    public ConsultaCursosTableModel(List<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }


    @Override
    public int getRowCount() {
        return listaCursos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { 
        return listaCursos.get(rowIndex).getNome(); 
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       return String.class; 
    } 
}
