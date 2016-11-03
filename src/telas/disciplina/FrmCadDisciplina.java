/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.disciplina;

import controller.CursosController;
import controller.DisciplinaController;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cursos;
import model.Disciplinas;
import model.Matriculas;
import telas.curso.*;
import util.Formatacao;

/**
 *
 * @author Alecsander
 */
public class FrmCadDisciplina extends JFrame {
    
    private Disciplinas disciplina;
    private IDisciplina telaDisciplina;
    private Cursos curso;
    
    public FrmCadDisciplina(Disciplinas disciplina, IDisciplina telaDisciplina) {
        this.disciplina = disciplina;
        this.telaDisciplina = telaDisciplina;
        initComponents();
        carregandoComboCurso();
        if (disciplina.getId() == null){
            disciplina = new Disciplinas();
        } else {
            curso = disciplina.getCursos();
            txtNomeDisciplina.setText(disciplina.getNome());
            cbxCurso.setSelectedItem(curso.getId());
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void carregandoComboCurso() {
        CursosController cursosController = new CursosController();
        String sql = "select c from Cursos c order by c.nome";
        List<Cursos> listaCursos = cursosController.listar(sql);
        if (listaCursos != null) {
            cbxCurso = Formatacao.preencherComobox(listaCursos, cbxCurso, true, "Selecione");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnPesquisar4 = new javax.swing.JButton();
        lblNomeCurso1 = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();

        setTitle("Cadastro de Disciplina");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNomeCurso.setText("Nome da Disciplina:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtNomeDisciplina.setAlignmentX(0.1F);
        txtNomeDisciplina.setAlignmentY(0.1F);
        txtNomeDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDisciplinaActionPerformed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorder(null);
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfirmar.setPreferredSize(new java.awt.Dimension(80, 90));
        btnConfirmar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnPesquisar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnPesquisar4.setText("Cancelar");
        btnPesquisar4.setBorder(null);
        btnPesquisar4.setBorderPainted(false);
        btnPesquisar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar4.setPreferredSize(new java.awt.Dimension(80, 90));
        btnPesquisar4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar4ActionPerformed(evt);
            }
        });

        lblNomeCurso1.setText("Curso:");
        lblNomeCurso1.setAlignmentY(0.1F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(lblNomeCurso)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomeCurso1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeCurso1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisar4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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

    private void btnPesquisar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnPesquisar4ActionPerformed

    private void txtNomeDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDisciplinaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        String validar = validarDados();
        if (validar.length() < 5) {
            preencherModelDisciplina();
        } else {
            JOptionPane.showMessageDialog(rootPane, validar);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPesquisar4;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeCurso1;
    private javax.swing.JTextField txtNomeDisciplina;
    // End of variables declaration//GEN-END:variables

    private String validarDados() {
        String dados = "";
        if (txtNomeDisciplina.getText().length() == 0) {
            dados = dados + " Disciplina não informada.";
        }
        if (cbxCurso.getSelectedItem() == null || cbxCurso.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
            dados = dados + " Curso não informado.";
        }
        return dados;
    }

    private void preencherModelDisciplina() {
        disciplina.setNome(txtNomeDisciplina.getText());
        DisciplinaController disciplinaController = new DisciplinaController();
        Cursos curso = (Cursos) cbxCurso.getSelectedItem();
        disciplina.setCursos(curso);
        disciplina = disciplinaController.salvar(disciplina);
        telaDisciplina.setModel();
        this.dispose();
    }
}
