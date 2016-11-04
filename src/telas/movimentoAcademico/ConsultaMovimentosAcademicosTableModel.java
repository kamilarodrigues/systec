package telas.movimentoAcademico;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.MovimentosAcademicos;

/**
 *
 * @author felipemoura
 */
public class ConsultaMovimentosAcademicosTableModel extends AbstractTableModel {
    private List<MovimentosAcademicos> listaMovimentos;
    private String[] colunas ={"Aluno","Turma", "Disciplina", "Situação"};

    public ConsultaMovimentosAcademicosTableModel(List<MovimentosAcademicos> listaMovimentos) {
        this.listaMovimentos = listaMovimentos;
    }

    @Override
    public int getRowCount() {
        return listaMovimentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return listaMovimentos.get(rowIndex).getMatriculasId().getAlunosId().getNome();
        }else if (columnIndex==1){
            return listaMovimentos.get(rowIndex).getMatriculasId().getTurmasId().getCodigo();
        } else if(columnIndex==2) {
            return listaMovimentos.get(rowIndex).getDisciplinasId().getNome();
        } else {
            return listaMovimentos.get(rowIndex).getSituacao();
        }
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
        }else if (columnIndex==2){
             return String.class; 
        } else return String.class;
    } 
}
