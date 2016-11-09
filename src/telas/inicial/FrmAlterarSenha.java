package telas.inicial;
  
import controller.UsuarioController;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import model.Usuario;  
import util.Criptografia;
import util.Formatacao;

 
public class FrmAlterarSenha extends javax.swing.JDialog {
    
    private Usuario usuario;
    private JButton btnSalvar, btnCancelar;
    private JPasswordField confirmaNovaSenhajPasswordField;
    private JLabel jLabel1, jLabel2;
    private JPanel jPanel1;
    private JPasswordField novaSenhajPasswordField; 

 
    public FrmAlterarSenha(Usuario usuario) {
        this.usuario = usuario;
        initComponents(); 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
 
    @SuppressWarnings("unchecked")
    private void initComponents() {
        URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        novaSenhajPasswordField = new javax.swing.JPasswordField();
        confirmaNovaSenhajPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alterar Senha");

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btnSalvar.setText("Confirmar");
        btnSalvar.setToolTipText("Confirma entrada no sistema");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Fechar");
        btnCancelar.setToolTipText("Sair do Sistema");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nova Senha");

        jLabel2.setText("Confirma Nova Senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(novaSenhajPasswordField)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmaNovaSenhajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novaSenhajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmaNovaSenhajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if(novaSenhajPasswordField.getText()!=null && novaSenhajPasswordField.getText().length()>0){
            if(confirmaNovaSenhajPasswordField.getText()!=null && confirmaNovaSenhajPasswordField.getText().length()>0){
                if (Arrays.equals(novaSenhajPasswordField.getPassword(), confirmaNovaSenhajPasswordField.getPassword())) {
                    String senha = Formatacao.SenhaString((confirmaNovaSenhajPasswordField.getPassword()));
                     try {
                        usuario.setSenha(Criptografia.encript(senha));   
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(FrmAlterarSenha.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    UsuarioController usuarioController = new UsuarioController();
                    usuarioController.salvar(usuario);
                    JOptionPane.showMessageDialog(rootPane, "Senha alterada com sucesso");
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Senhas não conferem");
                    novaSenhajPasswordField.requestFocus();
                    novaSenhajPasswordField.selectAll();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Campo confirmar nova senha em branco");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Campo nova senha em branco");

        }
    }

}
