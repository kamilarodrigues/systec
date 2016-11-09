package telas.turma; 

import controller.TurmaController;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Turmas;

/**
 *
 * @author Krystian
 */
public class FrmConsTurma extends javax.swing.JFrame implements ITurmas {

    private List<Turmas> listaTurmas;
    private ConsultaTurmasTableModel modelTurmas;
    private JButton btnEditar, btnExcluir, btnAdicionar,btnPesquisar;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel lblNomeCurso,lblCurso;
    private JTable tabelaTurmas;
    private JTextField txtCodigoTurma,txtNomeCurso;

    
    public FrmConsTurma() {
        initComponents();
        this.setLocationRelativeTo(null);
        setModel();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
            
        URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtCodigoTurma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTurmas = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNomeCurso = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
 

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNomeCurso.setText("Código da Turma:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtCodigoTurma.setAlignmentX(0.1F);
        txtCodigoTurma.setAlignmentY(0.1F);

        tabelaTurmas.setBackground(new java.awt.Color(204, 255, 204));
        tabelaTurmas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 204), new java.awt.Color(204, 255, 204), null, null));
        tabelaTurmas.setFont(new java.awt.Font("Arial", 0, 11)); 
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
        jScrollPane1.setViewportView(tabelaTurmas);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); 
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

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); 
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

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); 
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

        lblCurso.setText("Nome do Curso:");
        lblCurso.setAlignmentY(0.1F);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); 
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
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(lblCurso)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar)))
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
                            .addComponent(lblCurso))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar)
                        .addComponent(txtCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        Turmas turmas = new Turmas();
        new FrmCadTurma(turmas, this);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
       int linha = tabelaTurmas.getSelectedRow();
       if(linha >= 0){
           new FrmCadTurma(listaTurmas.get(linha), this);
       }else{
           JOptionPane.showMessageDialog(rootPane, "Selecione uma Turma");
       }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        TurmaController turmasController = new TurmaController();
        int linha = tabelaTurmas.getSelectedRow();
        if(linha >= 0) {
            turmasController.excluir(listaTurmas.get(linha).getId());
            setModel();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Turma");
        }
    }

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
