/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.aluno;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.view.ViewAlunos;
import model.view.ViewMatriculas;

/**
 *
 * @author Wolverine
 */
public class ConsultaAlunosTableModel extends AbstractTableModel{
    
    private List<ViewMatriculas> listaAlunos;
    private String[] colunas ={"Id", "Nome"};

    public ConsultaAlunosTableModel(List<ViewMatriculas> listaAlunos) {
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
            return listaAlunos.get(rowIndex).getId();
        }if (columnIndex==1){
            return listaAlunos.get(rowIndex).getAlunos_id();
        }else return listaAlunos.get(rowIndex).getMatricula();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==0){
            return Integer.class;
        }else if (columnIndex==1){
             return Integer.class;
         }else if (columnIndex==2){
             return  String.class;
         }else return String.class;
    } 
}
