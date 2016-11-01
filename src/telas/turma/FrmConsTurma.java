package telas.turma; 

import controller.TurmaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Turmas;

/**
 *
 * @author Kamila
 */
public class FrmConsTurma extends javax.swing.JFrame implements ITurmas {

    private List<Turmas> listaTurmas;
    private ConsultaTurmasTableModel modelTurmas;
    
    public FrmConsTurma() {
        initComponents();
        this.setLocationRelativeTo(null);
        setModel();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblNomeCurso1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtCodigoTurma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTurmas = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNomeCurso = new javax.swing.JTextField();
        lblNomeCurso2 = new javax.swing.JLabel();
        btnPesquisar1 = new javax.swing.JButton();

        jTextField2.setAlignmentX(0.1F);
        jTextField2.setAlignmentY(0.1F);

        lblNomeCurso1.setText("Nome da Disciplina:");
        lblNomeCurso1.setAlignmentY(0.1F);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeCurso.setText("Código da Turma:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtCodigoTurma.setAlignmentX(0.1F);
        txtCodigoTurma.setAlignmentY(0.1F);

        tabelaTurmas.setBackground(new java.awt.Color(204, 255, 204));
        tabelaTurmas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), null, null));
        tabelaTurmas.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabelaTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código da Turma", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTurmas.setGridColor(new java.awt.Color(0, 102, 51));
        tabelaTurmas.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabelaTurmas.setSelectionForeground(new java.awt.Color(204, 255, 204));
        tabelaTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTurmas);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnPesquisar.setText("Novo");
        btnPesquisar.setBorder(null);
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setPreferredSize(new java.awt.Dimension(80, 90));
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

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

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setBorderPainted(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setPreferredSize(new java.awt.Dimension(80, 90));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtNomeCurso.setAlignmentX(0.1F);
        txtNomeCurso.setAlignmentY(0.1F);

        lblNomeCurso2.setText("Nome do Curso:");
        lblNomeCurso2.setAlignmentY(0.1F);

        btnPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar1.setText("Pesquisar");
        btnPesquisar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeCurso))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeCurso2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeCurso)
                            .addComponent(lblNomeCurso2))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar1)
                        .addComponent(txtCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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

    private void tabelaTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTurmasMouseClicked

    }//GEN-LAST:event_tabelaTurmasMouseClicked

    private void btnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar1ActionPerformed
        TurmaController turmaController = new TurmaController();
        String sql = "select t from Turmas t where t.codigo like '%" + txtCodigoTurma.getText() + "%' ";
        if (txtNomeCurso.getText().length()>0){
            sql = sql + " and t.cursosId.nome like '%" + txtNomeCurso.getText() + "%' ";
        }
        sql = sql +" order by t.codigo";
        listaTurmas = turmaController.listar(sql);
        if (listaTurmas == null) {
            listaTurmas = new ArrayList<Turmas>();
        }
        modelTurmas = new ConsultaTurmasTableModel(listaTurmas);
        tabelaTurmas.setModel(modelTurmas);
        tabelaTurmas.repaint();
    }//GEN-LAST:event_btnPesquisar1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Turmas turmas = new Turmas();
        new FrmCadTurma(turmas, this);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       int linha = tabelaTurmas.getSelectedRow();
       if(linha >= 0){
           new FrmCadTurma(listaTurmas.get(linha), this);
       }else{
           JOptionPane.showMessageDialog(rootPane, "Selecione uma Turma");
       }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        TurmaController turmasController = new TurmaController();
        int linha = tabelaTurmas.getSelectedRow();
        if(linha >= 0) {
            turmasController.excluir(listaTurmas.get(linha).getId());
            setModel();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Turma");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeCurso1;
    private javax.swing.JLabel lblNomeCurso2;
    private javax.swing.JTable tabelaTurmas;
    private javax.swing.JTextField txtCodigoTurma;
    private javax.swing.JTextField txtNomeCurso;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setModel() {
        TurmaController turmaController = new TurmaController();
        String sql = "select t from Turmas t order by t.codigo";
        listaTurmas = turmaController.listar(sql);
        if (listaTurmas == null) {
            listaTurmas = new ArrayList<Turmas>();
        }
        modelTurmas = new ConsultaTurmasTableModel(listaTurmas);
        tabelaTurmas.setModel(modelTurmas);
        tabelaTurmas.repaint();
    }
    
    
    
}
