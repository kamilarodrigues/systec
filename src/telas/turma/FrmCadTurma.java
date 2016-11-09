package telas.turma; 

import controller.CursosController;
import controller.TurmaController;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Cursos;
import model.Turmas;
import util.Formatacao;

/**
 *
 * @author Krystian
 */
public class FrmCadTurma extends javax.swing.JFrame {

    private Turmas turmas;
    private Cursos cursos;
    private ITurmas telaTurmas;
    private JButton btnConfirmar,btnPesquisar4;
    private JComboBox<String> cbxCurso;
    private JPanel jPanel1;
    private JLabel lblTurma,lblCurso;
    private JTextField txtCodigoTurma;

    
    public FrmCadTurma(Turmas turmas, ITurmas telaTurmas) {
        this.turmas = turmas;
        this.telaTurmas = telaTurmas;
        initComponents();
        carregarComboCurso();
        if (turmas.getId() == null) {
            turmas = new Turmas();
        }else{
            cursos = turmas.getCursosId();
            txtCodigoTurma.setText(turmas.getCodigo());
            cbxCurso.setSelectedItem(turmas.getCursosId());
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

        @SuppressWarnings("unchecked")
    private void initComponents() {        
        URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        jPanel1 = new javax.swing.JPanel();
        lblTurma = new javax.swing.JLabel();
        txtCodigoTurma = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnPesquisar4 = new javax.swing.JButton();
        lblCurso = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTurma.setText("Código da Turma:");
        lblTurma.setAlignmentY(0.1F);

        txtCodigoTurma.setAlignmentX(0.1F);
        txtCodigoTurma.setAlignmentY(0.1F); 

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png")));         btnConfirmar.setText("Confirmar");
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

        btnPesquisar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png")));
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

        lblCurso.setText("Curso:");
        lblCurso.setAlignmentY(0.1F);

        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        }); 

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(lblTurma)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCurso))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    }

    private void btnPesquisar4ActionPerformed(java.awt.event.ActionEvent evt) {
       this.dispose();
    }

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {
        Object obj = cbxCurso.getSelectedItem();
        if (obj instanceof Cursos) {
            cursos = (Cursos) obj;
        }
}

    public String confirmarDados() {
        String dados = "";
        if (txtCodigoTurma.getText().length() == 0) {
            dados = dados + "Nome da Turma não informado.";
        }
        if (cbxCurso.getSelectedItem()== null){
            dados = dados + "Curso não foi informado.";
        }
        return dados;
    }
    
    public void preencherModelTurma() {
        turmas.setCodigo(txtCodigoTurma.getText());
        turmas.setCursosId(cursos);
        TurmaController turmaCotroller = new TurmaController();
        turmas = turmaCotroller.salvar(turmas);
        telaTurmas.setModel();
        this.dispose();
    }
    
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
       String confirmar = confirmarDados();
       if(confirmar.length() < 1) {
           preencherModelTurma();
       } else {
           JOptionPane.showMessageDialog(rootPane, confirmar);
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


