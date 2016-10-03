package telas.aluno;

import controller.CursosController;
import controller.DisciplinaController;
import controller.MatriculaController;
import controller.TurmaController;
import java.util.ArrayList;
import java.util.List; 
import model.Cursos;
import model.Disciplinas;
import model.Matriculas;
import model.Turmas;
import util.Formatacao;

/**
 *
 * @author Kamila
 */
public class FrmConsAluno extends javax.swing.JFrame implements IAlunos {

    private List<Matriculas> listaAlunos;
    private ConsultaAlunosTableModel modelAlunos;

    public FrmConsAluno() {
        initComponents();
        this.setLocationRelativeTo(null);
        setModel();
        this.setVisible(true); 
        carregarComboCurso();
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblNomeCurso1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblNomeCurso2 = new javax.swing.JLabel();
        lblNomeCurso3 = new javax.swing.JLabel();
        lblNomeCurso4 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        cbxTurma = new javax.swing.JComboBox<String>();
        cbxCurso = new javax.swing.JComboBox<String>();
        cbxDisciplina = new javax.swing.JComboBox<String>();

        jTextField2.setAlignmentX(0.1F);
        jTextField2.setAlignmentY(0.1F);

        lblNomeCurso1.setText("Nome da Disciplina:");
        lblNomeCurso1.setAlignmentY(0.1F);

        setTitle("Consulta de Alunos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeCurso.setText("Nome do Aluno:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtNomeAluno.setAlignmentX(0.1F);
        txtNomeAluno.setAlignmentY(0.1F);

        tabelaAlunos.setBackground(new java.awt.Color(204, 255, 204));
        tabelaAlunos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), null, null));
        tabelaAlunos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Turma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAlunos.setFocusable(false);
        tabelaAlunos.setGridColor(new java.awt.Color(0, 102, 51));
        tabelaAlunos.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabelaAlunos.setSelectionForeground(new java.awt.Color(204, 255, 204));
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlunos);

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(null);
        btnNovo.setBorderPainted(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setPreferredSize(new java.awt.Dimension(80, 90));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setPreferredSize(new java.awt.Dimension(80, 90));
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setBorderPainted(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setPreferredSize(new java.awt.Dimension(80, 90));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblNomeCurso2.setText("Curso:");
        lblNomeCurso2.setAlignmentY(0.1F);

        lblNomeCurso3.setText("Turma:");
        lblNomeCurso3.setAlignmentY(0.1F);

        lblNomeCurso4.setText("Disciplina:");
        lblNomeCurso4.setAlignmentY(0.1F);

        btnPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(null);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbxTurma.setToolTipText("");
        cbxTurma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTurmaItemStateChanged(evt);
            }
        });

        cbxCurso.setBackground(new java.awt.Color(204, 255, 204));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        cbxDisciplina.setToolTipText("");
        cbxDisciplina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDisciplinaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNomeCurso)
                            .addComponent(lblNomeCurso4)
                            .addComponent(txtNomeAluno)
                            .addComponent(cbxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeCurso3)
                            .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeCurso2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomeCurso2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomeCurso)
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeCurso4)
                            .addComponent(lblNomeCurso3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked

    }//GEN-LAST:event_tabelaAlunosMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Matriculas matriculas = new Matriculas();
        new FrmCadAluno(matriculas, this);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tabelaAlunos.getSelectedRow();
        if (linha>=0){
             new FrmCadAluno(listaAlunos.get(linha), this);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbxTurmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTurmaItemStateChanged
        Object obj = cbxTurma.getSelectedItem();
        Turmas turmas = null;
        if (obj instanceof Turmas) {
            turmas = (Turmas) obj;
        }
    }//GEN-LAST:event_cbxTurmaItemStateChanged

    private void cbxDisciplinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDisciplinaItemStateChanged
        Object obj = cbxDisciplina.getSelectedItem();
        Disciplinas disciplinas = null;
        if (obj instanceof Disciplinas) {
            disciplinas = (Disciplinas) obj;
        }
    }//GEN-LAST:event_cbxDisciplinaItemStateChanged

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCursoItemStateChanged
        Object obj = cbxCurso.getSelectedItem();
        Cursos cursos = null;
        if (obj instanceof Cursos) {
            cursos = (Cursos) obj;
        }
        if (cursos!=null){
            carregarComboTurma(cursos);
            carregarComboDisciplina(cursos);
        }
    }//GEN-LAST:event_cbxCursoItemStateChanged

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
      
    }//GEN-LAST:event_cbxCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxDisciplina;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeCurso1;
    private javax.swing.JLabel lblNomeCurso2;
    private javax.swing.JLabel lblNomeCurso3;
    private javax.swing.JLabel lblNomeCurso4;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtNomeAluno;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setModel() {
        MatriculaController matriculasController = new MatriculaController();
        String sql = "select m from Matriculas m order by m.alunosId.nome";
        listaAlunos = matriculasController.listar(sql);
        if (listaAlunos == null) {
            listaAlunos = new ArrayList<Matriculas>();
        }
        modelAlunos = new ConsultaAlunosTableModel(listaAlunos);
        tabelaAlunos.setModel(modelAlunos);
        tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaAlunos.repaint();
    }

    public void carregarComboTurma(Cursos cursos) {   
        if(cursos!=null){ 
            cbxTurma.removeAllItems();
            TurmaController turmasController = new TurmaController();
            String sql = "select t from Turmas t where t.cursosId.id="+cursos.getId()+" order by t.codigo";
            List<Turmas> listaTurmas = turmasController.listar(sql);
            if (listaTurmas != null) {
                cbxTurma = Formatacao.preencherComobox(listaTurmas, cbxTurma, true, "Selecione");
            }
        }
    }

    public void carregarComboDisciplina(Cursos cursos) {  
        if(cursos!=null){ 
            cbxDisciplina.removeAllItems();
            DisciplinaController disciplinaController = new DisciplinaController();
            String sql = "select d from Disciplinas d where d.cursos.id="+cursos.getId()+" order by d.nome";
            List<Disciplinas> listaDisciplina = disciplinaController.listar(sql);
            if (listaDisciplina != null) {
                cbxDisciplina = Formatacao.preencherComobox(listaDisciplina, cbxDisciplina, true, "Selecione");
            }
        }
    }
    
    public void carregarComboCurso() {
        CursosController cursosController = new CursosController();
        String sql = "select c from Cursos c order by c.nome";
        List<Cursos> listaCursos = cursosController.listar(sql);
        if (listaCursos != null) {
            cbxCurso = Formatacao.preencherComobox(listaCursos, cbxCurso, true, "Selecione");
        }
    }
}
