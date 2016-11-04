package telas.disciplina;

import controller.DisciplinaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Disciplinas;

/**
 *
 * @author Alecsander
 */
public class FrmConsDisciplina extends javax.swing.JFrame implements IDisciplina {

    private List<Disciplinas> listaDisciplina;
    private ConsultaDisciplinasTableModel modelDisciplina;
    private JButton btnEditar, btnExcluir, btnAdicionar, btnPesquisar;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel lblNomeCurso, lblNomeCurso1, lblNomeCurso2;
    private JTable tabelaDisciplina;
    private JTextField txtNomeCurso, txtNomeDisciplina;

    public FrmConsDisciplina() {
        iniciandoComponentes();
        this.setLocationRelativeTo(null);
        setModel();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void iniciandoComponentes() {
        lblNomeCurso1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplina = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNomeCurso = new javax.swing.JTextField();
        lblNomeCurso2 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        lblNomeCurso1.setText("Nome da Disciplina:");
        lblNomeCurso1.setAlignmentY(0.1F);

        setTitle("Consulta de Disciplina");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeCurso.setText("Nome da Disciplina:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtNomeDisciplina.setAlignmentX(0.1F);
        txtNomeDisciplina.setAlignmentY(0.1F);

        tabelaDisciplina.setBackground(new java.awt.Color(204, 255, 204));
        tabelaDisciplina.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), null, null));
        tabelaDisciplina.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabelaDisciplina.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String[]{
                    "Nome", "Curso"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabelaDisciplina.setGridColor(new java.awt.Color(0, 102, 51));
        tabelaDisciplina.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabelaDisciplina.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setViewportView(tabelaDisciplina);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnAdicionar.setText("Novo");
        btnAdicionar.setBorder(null);
        btnAdicionar.setBorderPainted(false);
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setPreferredSize(new java.awt.Dimension(80, 90));
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
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

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomeCurso))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNomeCurso2)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnPesquisar)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblNomeCurso)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblNomeCurso2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        DisciplinaController disciplinaController = new DisciplinaController();
        String sql = "select d from Disciplinas d where d.nome like '%" + txtNomeDisciplina.getText() + "%'";
        if (txtNomeCurso.getText().length() > 0) {
            sql = sql + " and d.cursos.nome like '%" + txtNomeCurso.getText() + "%'";
        }
        listaDisciplina = disciplinaController.listar(sql);
        if (listaDisciplina == null) {
            listaDisciplina = new ArrayList<Disciplinas>();
        }
        modelDisciplina = new ConsultaDisciplinasTableModel(listaDisciplina);
        tabelaDisciplina.setModel(modelDisciplina);
        tabelaDisciplina.repaint();
    }

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmCadDisciplina(new Disciplinas(), this);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabelaDisciplina.getSelectedRow();
        if (linha >= 0) {
            new FrmCadDisciplina(listaDisciplina.get(linha), this);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Disciplina");
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        DisciplinaController disciplinaController = new DisciplinaController();
        int linha = tabelaDisciplina.getSelectedRow();
        if (linha >= 0) {
            disciplinaController.excluir(listaDisciplina.get(linha).getId());
            setModel();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Disciplina");
        }
    }

    @Override
    public void setModel() {
        DisciplinaController disciplinaController = new DisciplinaController();
        String sql = "select d from Disciplinas d order by d.nome,d.cursos.nome";
        listaDisciplina = disciplinaController.listar(sql);
        if (listaDisciplina == null) {
            listaDisciplina = new ArrayList<Disciplinas>();
        }
        modelDisciplina = new ConsultaDisciplinasTableModel(listaDisciplina);
        tabelaDisciplina.setModel(modelDisciplina);
        tabelaDisciplina.repaint();
    }
}
