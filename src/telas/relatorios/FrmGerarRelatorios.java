package telas.relatorios; 

import controller.CursosController; 
import java.util.List;
import model.Cursos;
import model.Disciplinas;
import model.Turmas; 
import util.Formatacao;

/**
 *
 * @author Kamila
 */
public class FrmGerarRelatorios extends javax.swing.JFrame {

    
    public FrmGerarRelatorios() {
        //carregando os componentes da tela
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //carregar as informações para o combobox de curso
        carregarComboCurso();
    }

    
    @SuppressWarnings("unchecked") 
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblNomeCurso1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso3 = new javax.swing.JLabel();
        lblNomeCurso4 = new javax.swing.JLabel();
        btnGerarRelatorio = new javax.swing.JButton();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxDisciplina = new javax.swing.JComboBox<>();
        cbxCurso = new javax.swing.JComboBox<>();
        lblNomeCurso2 = new javax.swing.JLabel();

        jTextField2.setAlignmentX(0.1F);
        jTextField2.setAlignmentY(0.1F);

        lblNomeCurso1.setText("Nome da Disciplina:");
        lblNomeCurso1.setAlignmentY(0.1F);

        setTitle("Movimento Academico");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeCurso3.setText("Turma:");
        lblNomeCurso3.setAlignmentY(0.1F);

        lblNomeCurso4.setText("Disciplina:");
        lblNomeCurso4.setAlignmentY(0.1F);

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png")));  
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerarRelatorio.setOpaque(false);
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnGerarRelatorioActionPerformed(evt);
            }
        });

        cbxCurso.setBackground(new java.awt.Color(204, 255, 204));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        }); 

        lblNomeCurso2.setText("Curso:");
        lblNomeCurso2.setAlignmentY(0.1F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNomeCurso3)
                        .addComponent(cbxDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomeCurso4)
                        .addComponent(lblNomeCurso2)
                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblNomeCurso2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeCurso3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeCurso4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }  

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {                                          
        //após selecionar um item ele irá executar este metódo para buscar o curso selecionado.
        if(cbxCurso!=null){
            Object obj = cbxCurso.getSelectedItem();
            Cursos cursos = null;
            if (obj instanceof Cursos) {
                cursos = (Cursos) obj;
            }
            if (cursos!=null){
                //carregar as turmas e as disciplinas que pertencem ao curso selecionado
                carregarComboTurma(cursos);
                carregarComboDisciplina(cursos);
            }
        }
    }                                          
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxDisciplina;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblNomeCurso1;
    private javax.swing.JLabel lblNomeCurso2;
    private javax.swing.JLabel lblNomeCurso3;
    private javax.swing.JLabel lblNomeCurso4;
    // End of variables declaration//GEN-END:variables
   
    public void carregarComboCurso() {
        CursosController cursosController = new CursosController();
        String sql = "select c from Cursos c order by c.nome";
        List<Cursos> listaCursos = cursosController.listar(sql);
        if (listaCursos != null) {
            cbxCurso = Formatacao.preencherComobox(listaCursos, cbxCurso, true, "Selecione");
        }
    }
    
    public void carregarComboTurma(Cursos cursos) {   
        if(cursos!=null){ 
            cbxTurma.removeAllItems(); 
            List<Turmas> listaTurmas = cursos.getTurmasList();
            if (listaTurmas != null) {
                cbxTurma = Formatacao.preencherComobox(listaTurmas, cbxTurma, true, "Selecione");
            }
        }else{
            cbxTurma.removeAllItems();
        }
    }
    
    
    public void carregarComboDisciplina(Cursos cursos) {   
        if(cursos!=null){ 
            cbxDisciplina.removeAllItems();
            List<Disciplinas> listaDisciplinas = cursos.getDisciplinasList();
            if (listaDisciplinas != null) {
                cbxDisciplina = Formatacao.preencherComobox(listaDisciplinas, cbxDisciplina, true, "Selecione");
            }
        }else{
            cbxDisciplina.removeAllItems();
        }
    }

}
