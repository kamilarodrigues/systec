package telas.movimentoAcademico; 

import controller.CursosController;
import controller.DisciplinaController; 
import controller.MovimentoAcademicoController;
import controller.TurmaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Cursos;
import model.Disciplinas; 
import model.MovimentosAcademicos;
import model.Turmas; 
import util.Formatacao;

/**
 *
 * @author Felipemouro
 */
public class FrmMovimentoAcademico extends javax.swing.JFrame implements IMovimentosAcademicos {
    
    private List<MovimentosAcademicos> listaAlunos;
    private ConsultaMovimentosAcademicosTableModel modelMovimentos;
    private JButton btnSituacao,btnPesquisar;
    private JComboBox<String> cbxCursos,cbxDisciplinas,cbxTurma;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField jTextField2;
    private JLabel lblTurma,lblCurso,lblDisciplina;
    private JTable tabelaCursos;

    
    public FrmMovimentoAcademico() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        carregarComboCurso();
        setModel();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField(); 
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCursos = new javax.swing.JTable();
        btnSituacao = new javax.swing.JButton();
        lblTurma = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxCursos = new javax.swing.JComboBox<>();
        cbxDisciplinas = new javax.swing.JComboBox<>();
        lblDisciplina = new javax.swing.JLabel();

        jTextField2.setAlignmentX(0.1F);
        jTextField2.setAlignmentY(0.1F); 

        setTitle("Movimento Academico");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaCursos.setBackground(new java.awt.Color(204, 255, 204));
        tabelaCursos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), null, null));
        tabelaCursos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabelaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Aluno", "Turma", "Disciplina", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCursos.setGridColor(new java.awt.Color(0, 102, 51));
        tabelaCursos.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabelaCursos.setSelectionForeground(new java.awt.Color(204, 255, 204)); 
        jScrollPane1.setViewportView(tabelaCursos);

        btnSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/situacao.png"))); // NOI18N
        btnSituacao.setText("Situação");
        btnSituacao.setBorderPainted(false);
        btnSituacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSituacao.setPreferredSize(new java.awt.Dimension(80, 90));
        btnSituacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSituacaoActionPerformed(evt);
            }
        });

        lblTurma.setText("Turma:");
        lblTurma.setAlignmentY(0.1F);

        lblCurso.setText("Curso:");
        lblCurso.setAlignmentY(0.1F);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesquisar.setOpaque(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        }); 

        cbxCursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursosItemStateChanged(evt);
            }
        });  

        lblDisciplina.setText("Disciplina:");
        lblDisciplina.setAlignmentY(0.1F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurso)
                            .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurma)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 229, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisciplina)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btnSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTurma)
                            .addComponent(lblCurso))
                        .addGap(26, 26, 26)))
                .addGap(7, 7, 7)
                .addComponent(lblDisciplina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addComponent(cbxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt){
        setModel();
    }

    private void btnSituacaoActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tabelaCursos.getSelectedRow();
        if(linha >= 0){
            new FrmSituacaoMovimentoAcademico(listaAlunos.get(linha), this);
        }else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Aluno");
        }
    }

    private void cbxCursosItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        Object obj = cbxCursos.getSelectedItem();
        Cursos cursos = null;
        if (obj instanceof Cursos) {
            cursos = (Cursos) obj;
        }
        if (cursos != null) {
            carregarComboTurmas(cursos);
            carregarComboDisciplinas(cursos);
            setModel();
        }
    }    
    
    public void carregarComboTurmas(Cursos curso) {
        TurmaController turmasController = new TurmaController();
        cbxTurma.removeAllItems();
        String sql = "select t from Turmas t where t.cursosId.id = "+curso.getId();
        List<Turmas> listaTurma = turmasController.listar(sql);
        if (listaTurma != null) {
            cbxTurma = Formatacao.preencherComobox(listaTurma, cbxTurma, true, "Selecione");
        } else {
            cbxTurma.removeAllItems();
        }
    }
    
    public void carregarComboCurso() {
        CursosController cursosController = new CursosController();
        String sql = "select c from Cursos c order by c.nome";
        List<Cursos> listaCursos = cursosController.listar(sql);
        if (listaCursos != null) {
            cbxCursos = Formatacao.preencherComobox(listaCursos, cbxCursos, true, "Selecione");
        } else {
            cbxCursos.removeAllItems();
        }
    }
    
    public void carregarComboDisciplinas(Cursos curso){
        DisciplinaController disciplinaController = new DisciplinaController();
        cbxDisciplinas.removeAllItems();
        String sql = "select d from Disciplinas d where d.cursos.id = "+curso.getId();
        List<Disciplinas> listaDisciplinas = disciplinaController.listar(sql);
        if (listaDisciplinas != null) {
            cbxDisciplinas = Formatacao.preencherComobox(listaDisciplinas, cbxDisciplinas, true, "Selecione");
        } else {
            cbxDisciplinas.removeAllItems();
        }
    }
    @Override
    public void setModel() {
       
        Cursos curso = null;
        Object objCurso = cbxCursos.getSelectedItem();
        Turmas turma = null;
        Object objTurma = cbxTurma.getSelectedItem();
        Object objDisciplina = cbxDisciplinas.getSelectedItem();
        Disciplinas disciplina = null;
        
        if(objDisciplina instanceof Disciplinas){
            disciplina =  (Disciplinas) objDisciplina;
        }
        if(objTurma instanceof Turmas){
            turma = (Turmas) objTurma;
        } 
        if(objCurso instanceof Cursos){
            curso = (Cursos) objCurso;
        } 
        
        MovimentoAcademicoController movimentoController = new MovimentoAcademicoController();
        if(curso == null || turma == null || disciplina==null){
            listaAlunos = new ArrayList<MovimentosAcademicos>();
        } else {
            String sql = "select m from MovimentosAcademicos m "
                    + "where m.matriculasId.turmasId.id = "+turma.getId()+
                    " and m.disciplinasId.id = "+disciplina.getId();

            listaAlunos = movimentoController.listar(sql);

            if (listaAlunos == null) {
                listaAlunos = new ArrayList<MovimentosAcademicos>();
            } 
        }
        modelMovimentos = new ConsultaMovimentosAcademicosTableModel(listaAlunos);
            tabelaCursos.setModel(modelMovimentos);
            tabelaCursos.getColumnModel().getColumn(0).setPreferredWidth(175);
            tabelaCursos.getColumnModel().getColumn(1).setPreferredWidth(175);
            tabelaCursos.getColumnModel().getColumn(2).setPreferredWidth(175);
            tabelaCursos.getColumnModel().getColumn(3).setPreferredWidth(175);
            tabelaCursos.repaint();
    }
}

