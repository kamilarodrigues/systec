package tela.inicial;
  
import controller.UsuarioController;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;  
import model.Usuario;
import telas.usuario.UsuarioLogadoBean; 
import util.Criptografia;
import util.Formatacao;

 
public class FrmLogin extends javax.swing.JDialog {
    
    private UsuarioLogadoBean usuarioLogadoBean;
    private JLabel nomeUsuariojLabel;
    private JLabel unidadejLabel;
    private java.awt.Frame telaPrincipal;
    private int contador;

    /**
     * Creates new form FrmLoginD
     */
    public FrmLogin(java.awt.Frame parent, boolean modal, UsuarioLogadoBean usuarioLogadoBean, JLabel nomeUsuariojLabel) {
        super(parent, modal);
        contador=0;
        this.telaPrincipal = parent;
        this.unidadejLabel = unidadejLabel;
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
        this.setVisible(true);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        senhajPasswordField = new javax.swing.JPasswordField();
        loginjButton = new javax.swing.JButton();
        sairjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SysTEC - Login");

        jLabel2.setText("Login do Usuário");

        jLabel1.setText("Senha de Acesso");

        loginjButton.setBackground(new java.awt.Color(204, 204, 204));
        loginjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        loginjButton.setText("Confirmar");
        loginjButton.setToolTipText("Confirma entrada no sistema");
        loginjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginjButtonActionPerformed(evt);
            }
        });

        sairjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        sairjButton.setText("Fechar");
        sairjButton.setToolTipText("Sair do Sistema");
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
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
                        .addComponent(loginjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sairjButton))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(senhajPasswordField)
                    .addComponent(loginjTextField))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sairjButton)
                    .addComponent(loginjButton))
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
    }// </editor-fold>//GEN-END:initComponents

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void loginjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginjButtonActionPerformed
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
    }//GEN-LAST:event_loginjButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginjButton;
    private javax.swing.JTextField loginjTextField;
    private javax.swing.JButton sairjButton;
    private javax.swing.JPasswordField senhajPasswordField;
    // End of variables declaration//GEN-END:variables

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
