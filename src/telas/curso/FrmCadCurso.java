package telas.curso;

import controller.CursosController;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import model.Cursos;

/**
 *
 * @author Kamila
 */
public class FrmCadCurso extends javax.swing.JFrame {

    public Cursos cursos;
    public ICurso telaCurso;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPesquisar4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JTextField txtNome; 
    
    public FrmCadCurso(Cursos cursos, ICurso telaCurso) {
        this.cursos=cursos;
        this.telaCurso = telaCurso;
        inserindoComponentes();
        txtNome.setText("");
        if(cursos!=null){
            txtNome.setText(cursos.getNome());
        }else{
            this.cursos = new Cursos();
        } 
        this.setLocationRelativeTo(null);
        this.setVisible(true); 
    }

     
    @SuppressWarnings("unchecked") 
    private void inserindoComponentes() {
        URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        jPanel1 = new javax.swing.JPanel();
        lblNomeCurso = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnPesquisar4 = new javax.swing.JButton();

        setTitle("Cadastro de Cursos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNomeCurso.setText("Nome do Curso:");
        lblNomeCurso.setAlignmentY(0.1F);

        txtNome.setAlignmentX(0.1F);
        txtNome.setAlignmentY(0.1F);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeCurso)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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

    private void btnPesquisar4ActionPerformed(java.awt.event.ActionEvent evt) {
       this.dispose();
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        if(txtNome.getText().length()>1){
            cursos.setNome(txtNome.getText());
            CursosController cursosController = new CursosController();
            cursosController.salvar(cursos);
            JOptionPane.showMessageDialog(rootPane, "Curso Salvo com Sucesso");
            telaCurso.setModelCurso();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do curso.");
        }
    } 
}
