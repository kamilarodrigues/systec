package telas.inicial;
  
import controller.UsuarioController;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;  
import model.Usuario;
import telas.usuario.UsuarioLogadoBean; 
import util.Criptografia;
import util.Formatacao;

 
public class FrmLogin extends javax.swing.JDialog {
    
    private UsuarioLogadoBean usuarioLogadoBean;
    private JLabel nomeUsuariojLabel;  
    private int contador;
    private JButton btnLogar,btnSair;
    private JLabel lblSenha,lblLogin;
    private JPanel jPanel1;
    private JTextField loginjTextField;
    private JPasswordField senhajPasswordField;


    public FrmLogin(java.awt.Frame parent, boolean modal, UsuarioLogadoBean usuarioLogadoBean, JLabel nomeUsuariojLabel) {
        super(parent, modal);
        contador=0; 
        this.usuarioLogadoBean = usuarioLogadoBean;
        this.nomeUsuariojLabel = nomeUsuariojLabel;
        initComponents();
       try{
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);  
            this.pack();  
        }catch (Exception e){
        }
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnLogar);
        this.setVisible(true); 
    }
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginjTextField = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        senhajPasswordField = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SysTEC - Login");

        lblLogin.setText("Login do Usuário");

        lblSenha.setText("Senha de Acesso");

        btnLogar.setBackground(new java.awt.Color(204, 204, 204));
        btnLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); 
        btnLogar.setText("Confirmar");
        btnLogar.setToolTipText("Confirma entrada no sistema");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); 
        btnSair.setText("Fechar");
        btnSair.setToolTipText("Sair do Sistema");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addComponent(lblSenha)
                    .addComponent(lblLogin)
                    .addComponent(senhajPasswordField)
                    .addComponent(loginjTextField))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnLogar))
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

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {
        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario;
        String senha = Formatacao.SenhaString(senhajPasswordField.getPassword());
        if (senhajPasswordField.getPassword().length > 0) {
            try {
                senha = Criptografia.encript(senha);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            usuario = usuarioController.consultar(loginjTextField.getText(), senha);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuario e/ou Senha não conferem");
                verificarContagem();
            } else {
                usuarioLogadoBean.setUsuario(usuario); 
                nomeUsuariojLabel.setText("Usuário : " + usuario.getNome());  
                setVisible(false);
                this.dispose();
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "Campo senha em branco");
        }
    }
   

    public void verificarContagem(){
        if (contador>4){
            JOptionPane.showMessageDialog(rootPane, "Excedeu numero de tentativas");
            System.exit(0);
        }else {
            contador++;
            loginjTextField.setText("");
            senhajPasswordField.setText("");
            loginjTextField.requestFocus();
        }
    }

}
