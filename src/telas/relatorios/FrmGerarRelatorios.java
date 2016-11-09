package telas.relatorios;

import controller.CursosController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Cursos;
import model.Disciplinas;
import model.Turmas;
import util.Formatacao;

/**
 *
 * @author Kamila
 */
public class FrmGerarRelatorios extends javax.swing.JFrame {

    private JButton btnGerarRelatorio;
    private JComboBox<String> cbxCurso, cbxDisciplina, cbxTurma;
    private JPanel jPanel1;
    private JLabel lblNomeCurso, lblNomeTurma, lblNomeDisciplina;

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

        jPanel1 = new javax.swing.JPanel();
        lblNomeTurma = new javax.swing.JLabel();
        lblNomeDisciplina = new javax.swing.JLabel();
        btnGerarRelatorio = new javax.swing.JButton();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxDisciplina = new javax.swing.JComboBox<>();
        cbxCurso = new javax.swing.JComboBox<>();
        lblNomeCurso = new javax.swing.JLabel();

        setTitle("Movimento Academico");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeTurma.setText("Turma:");
        lblNomeTurma.setAlignmentY(0.1F);

        lblNomeDisciplina.setText("Disciplina:");
        lblNomeDisciplina.setAlignmentY(0.1F);

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png")));
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGerarRelatorio.setOpaque(false);
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblNomeTurma)
                                                .addComponent(cbxDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblNomeDisciplina)
                                                .addComponent(lblNomeCurso)
                                                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblNomeCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomeTurma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomeDisciplina)
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
        if (cbxCurso != null) {
            Object obj = cbxCurso.getSelectedItem();
            Cursos cursos = null;
            if (obj instanceof Cursos) {
                cursos = (Cursos) obj;
            }
            if (cursos != null) {
                //carregar as turmas e as disciplinas que pertencem ao curso selecionado
                carregarComboTurma(cursos);
                carregarComboDisciplina(cursos);
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

    public void carregarComboTurma(Cursos cursos) {
        if (cursos != null) {
            cbxTurma.removeAllItems();
            List<Turmas> listaTurmas = cursos.getTurmasList();
            if (listaTurmas != null) {
                cbxTurma = Formatacao.preencherComobox(listaTurmas, cbxTurma, true, "Selecione");
            }
        } else {
            cbxTurma.removeAllItems();
        }
    }

    public void carregarComboDisciplina(Cursos cursos) {
        if (cursos != null) {
            cbxDisciplina.removeAllItems();
            List<Disciplinas> listaDisciplinas = cursos.getDisciplinasList();
            if (listaDisciplinas != null) {
                cbxDisciplina = Formatacao.preencherComobox(listaDisciplinas, cbxDisciplina, true, "Selecione");
            }
        } else {
            cbxDisciplina.removeAllItems();
        }
    }

    public void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {
        if (cbxCurso.getSelectedItem() != null && !cbxCurso.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
            if (cbxTurma.getSelectedItem() != null && !cbxTurma.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
                Object obj = cbxTurma.getSelectedItem();
                Turmas turmas = null;
                if (obj instanceof Turmas) {
                    turmas = (Turmas) obj;
                }
                Disciplinas disciplinas = null;
                if (cbxDisciplina.getSelectedItem() != null && !cbxDisciplina.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
                    obj = cbxDisciplina.getSelectedItem();
                    if (obj instanceof Disciplinas) {
                        disciplinas = (Disciplinas) obj;
                    }
                } 
                String sql = "select distinct matriculas.matricula, alunos.nome as aluno, movimentos_academicos.situacao, disciplinas.nome as disciplina, disciplinas.id"
                        + " from movimentos_academicos"
                        + " join matriculas on movimentos_academicos.matriculas_id = matriculas.id"
                        + " join alunos on matriculas.alunos_id = alunos.id"
                        + " join turmas on matriculas.turmas_id = turmas.id"
                        + " join disciplinas on movimentos_academicos.disciplinas_id = disciplinas.id"
                        + " join cursos on disciplinas.cursos_id = cursos.id" 
                        + " where ";
                if (disciplinas != null) {
                    sql = sql + "disciplinas.id=" + disciplinas.getId() + " and";
                }
                sql = sql + " turmas.id=" + turmas.getId() + " and cursos.id="+turmas.getCursosId().getId()+" order by disciplinas.nome";
                String url = ("reports/relatorioTurma.jasper");
                Map parameters = new HashMap();  
                parameters.put("turma", turmas.getCodigo());
                try {
                    parameters.put("sql", sql);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Não foi possível gerar o relatório " + ex);
                    ex.printStackTrace();
                }
                new RelatoriosJasper(url, parameters);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe a turma.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o curso.");
        }
    }
}
