package telas.aluno;

import controller.CursosController;
import controller.MatriculaController;
import controller.TurmaController;
import facade.MatriculasFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cursos;
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeCurso1;
    private javax.swing.JLabel lblNomeCurso2;
    private javax.swing.JLabel lblNomeCurso3;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField txtNomeAluno;

    public FrmConsAluno() {
        inserindoComponentes();
        this.setLocationRelativeTo(null);
        setModel();
        this.setVisible(true);
        carregarComboCurso();
    }

    @SuppressWarnings("unchecked")
    private void inserindoComponentes() {

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
        btnPesquisar = new javax.swing.JButton();
        cbxTurma = new javax.swing.JComboBox<String>();
        cbxCurso = new javax.swing.JComboBox<String>();
        btnLimpar = new javax.swing.JButton();

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
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Matricula", "Nome", "Turma"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabelaAlunos.setFocusable(false);
        tabelaAlunos.setGridColor(new java.awt.Color(0, 102, 51));
        tabelaAlunos.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabelaAlunos.setSelectionForeground(new java.awt.Color(204, 255, 204));
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
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblNomeCurso2.setText("Curso:");
        lblNomeCurso2.setAlignmentY(0.1F);

        lblNomeCurso3.setText("Turma:");
        lblNomeCurso3.setAlignmentY(0.1F);

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

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limparpesquisa.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(null);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
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
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNomeCurso)
                                                        .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomeCurso2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNomeCurso3)
                                                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)))
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
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblNomeCurso)
                                                                .addGap(26, 26, 26)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblNomeCurso3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(lblNomeCurso2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        MatriculaController matriculasController = new MatriculaController();
        String sql = "select m from Matriculas m where m.alunosId.nome like '%" + txtNomeAluno.getText() + "%' ";
        Object obj = cbxCurso.getSelectedItem();
        Cursos cursos = null;
        if (obj instanceof Cursos) {
            cursos = (Cursos) obj;
        }
        if (cursos != null) {
            sql = sql + " and m.turmasId.cursosId.id=" + cursos.getId();
        }
        obj = cbxTurma.getSelectedItem();
        Turmas turmas = null;
        if (obj instanceof Turmas) {
            turmas = (Turmas) obj;
        }
        if (turmas != null) {
            sql = sql + " and m.turmasId.id=" + turmas.getId();
        }
        sql = sql + " order by m.alunosId.nome";
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

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
        Matriculas matriculas = new Matriculas();
        new FrmCadAluno(matriculas, this);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabelaAlunos.getSelectedRow();
        if (linha >= 0) {
            new FrmCadAluno(listaAlunos.get(linha), this);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Aluno");
        }
    }

    private void cbxTurmaItemStateChanged(java.awt.event.ItemEvent evt) {
        Object obj = cbxTurma.getSelectedItem();
        Turmas turmas = null;
        if (obj instanceof Turmas) {
            turmas = (Turmas) obj;
        }
    }

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {
        Object obj = cbxCurso.getSelectedItem();
        Cursos cursos = null;
        if (obj instanceof Cursos) {
            cursos = (Cursos) obj;
        }
        if (cursos != null) {
            carregarComboTurma(cursos);
        }
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        txtNomeAluno.setText("");
        cbxCurso.setSelectedItem("Selecione");
        cbxTurma.setSelectedItem(null);
        carregarComboTurma(null);
        setModel();
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        MatriculasFacade matriculasFacade = new MatriculasFacade();
        int linha = tabelaAlunos.getSelectedRow();
        if (linha >= 0) {
            try {
                matriculasFacade.excluir(listaAlunos.get(linha).getId());
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            setModel();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Aluno");
        }
    }

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
        if (cursos != null) {
            cbxTurma.removeAllItems();
            TurmaController turmasController = new TurmaController();
            String sql = "select t from Turmas t where t.cursosId.id=" + cursos.getId() + " order by t.codigo";
            List<Turmas> listaTurmas = turmasController.listar(sql);
            if (listaTurmas != null) {
                cbxTurma = Formatacao.preencherComobox(listaTurmas, cbxTurma, true, "Selecione");
            }
        } else {
            cbxTurma.removeAllItems();
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
