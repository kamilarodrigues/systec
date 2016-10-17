package telas.aluno;

import controller.AlunosController;
import controller.CursosController;
import controller.MatriculaController;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Alunos;
import model.Cursos;
import model.Matriculas;
import model.Turmas;
import util.Formatacao;

/**
 *
 * @author Kamila
 */
public class FrmCadAluno extends JFrame {

    public Matriculas matriculas;
    private IAlunos telaAluno;
    private Alunos alunos;
    private JButton btnCancelar, btnConfirmar;
    private JComboBox<String> cbxCurso;
    private JComboBox cbxTurma;
    private JPanel jPanel1;
    private JLabel lblMatricula, lblNomeAluno, lblNomeTurma, lblNomeCurso;
    private JTextField txtMatricula, txtNomeAluno;

    public FrmCadAluno(Matriculas matriculas, IAlunos telaAluno) {
        this.matriculas = matriculas;
        this.telaAluno = telaAluno;
        inserindoComponentes();
        carregarComboCurso();
        if (matriculas.getId() == null) {
            alunos = new Alunos();
        } else {
            alunos = matriculas.getAlunosId();
            txtMatricula.setText(matriculas.getMatricula());
            txtNomeAluno.setText(alunos.getNome());
            cbxCurso.setSelectedItem(matriculas.getTurmasId().getCursosId());
            cbxTurma.setSelectedItem(matriculas.getTurmasId());
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void inserindoComponentes() {

        jPanel1 = new JPanel();
        lblMatricula = new JLabel();
        txtMatricula = new JTextField();
        lblNomeAluno = new JLabel();
        txtNomeAluno = new JTextField();
        lblNomeTurma = new JLabel();
        cbxTurma = new JComboBox();
        btnConfirmar = new JButton();
        btnCancelar = new JButton();
        cbxCurso = new JComboBox<String>();
        lblNomeCurso = new JLabel();

        setTitle("Cadastro de Alunos");

        lblMatricula.setText("Matricula:");
        lblMatricula.setAlignmentY(0.1F);

        txtMatricula.setAlignmentX(0.1F);
        txtMatricula.setAlignmentY(0.1F);

        lblNomeAluno.setText("Nome do Aluno:");
        lblNomeAluno.setAlignmentY(0.1F);

        txtNomeAluno.setAlignmentX(0.1F);
        txtNomeAluno.setAlignmentY(0.1F);

        lblNomeTurma.setText("Turma:");
        lblNomeTurma.setAlignmentY(0.1F);

        cbxTurma.setToolTipText("");
        cbxTurma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTurmaItemStateChanged(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setIcon(new ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
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

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setPreferredSize(new java.awt.Dimension(80, 90));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxCurso.setBackground(new java.awt.Color(204, 255, 204));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });

        lblNomeCurso.setText("Curso:");
        lblNomeCurso.setAlignmentY(0.1F);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(27, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblNomeCurso)
                                                        .addComponent(lblMatricula)
                                                        .addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomeAluno)
                                                        .addComponent(txtNomeAluno)
                                                        .addComponent(lblNomeTurma)
                                                        .addComponent(cbxTurma, 0, 300, Short.MAX_VALUE)
                                                        .addComponent(cbxCurso, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20, 20, 20))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblMatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomeAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeTurma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnConfirmar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancelar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        String validar = validarDados();
        if (validar.length() < 5) {
            preencherModelAluno();
        } else {
            JOptionPane.showMessageDialog(rootPane, validar);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
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

    public String validarDados() {
        String dados = "";
        if (txtMatricula.getText().length() == 0) {
            dados = dados + " Matrícula não informada.";
        }
        if (txtNomeAluno.getText().length() == 0) {
            dados = dados + " Nome não informado.";
        }
        if (cbxTurma.getSelectedItem() == null) {
            dados = dados + " Turma não informada.";
        }
        return dados;
    }

    public void preencherModelAluno() {
        alunos.setNome(txtNomeAluno.getText());
        AlunosController alunosController = new AlunosController();
        alunos = alunosController.salvar(alunos);
        matriculas.setMatricula(txtMatricula.getText());
        matriculas.setAlunosId(alunos);
        Turmas turmas = (Turmas) cbxTurma.getSelectedItem();
        matriculas.setTurmasId(turmas);
        MatriculaController matriculaController = new MatriculaController();
        matriculas = matriculaController.salvar(matriculas);
        telaAluno.setModel();
        this.dispose();
    }

    public void carregarComboTurma(Cursos cursos) {
        if (cursos != null) {
            cbxTurma.removeAllItems(); 
            List<Turmas> listaTurmas = cursos.getTurmasList();
            if (listaTurmas != null) {
                cbxTurma = Formatacao.preencherComobox(listaTurmas, cbxTurma, true, "Selecione");
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
