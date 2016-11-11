package telas.movimentoAcademico; 

import controller.MovimentoAcademicoController;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Matriculas;
import model.MovimentosAcademicos;

/**
 *
 * @author FelipeMoura
 */
public class FrmSituacaoMovimentoAcademico extends javax.swing.JFrame {
    
   private List<Matriculas> listaAlunos;
   private MovimentosAcademicos movimento;
   private IMovimentosAcademicos telaMovimentos;
   private JRadioButton aprovadojRadioButton, reprovadojRadioButton;
   private JButton btnConfirmar,btnCancelar;
   private JPanel jPanel1;
   private ButtonGroup situacaobuttonGroup;

    public FrmSituacaoMovimentoAcademico(MovimentosAcademicos movimento, IMovimentosAcademicos telaMovimento ) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.movimento = movimento;
        this.telaMovimentos = telaMovimento;
    }
    
    public boolean saveMovimentoAcademico(Object objAluno){
        return false;
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        situacaobuttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        aprovadojRadioButton = new javax.swing.JRadioButton();
        reprovadojRadioButton = new javax.swing.JRadioButton();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Situação");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(0));

        aprovadojRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        situacaobuttonGroup.add(aprovadojRadioButton);
        aprovadojRadioButton.setForeground(new java.awt.Color(0, 51, 0));
        aprovadojRadioButton.setText("Aprovado"); 

        reprovadojRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        situacaobuttonGroup.add(reprovadojRadioButton);
        reprovadojRadioButton.setText("Reprovado");
        reprovadojRadioButton.setBorder(null);
        reprovadojRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(aprovadojRadioButton)
                .addGap(35, 35, 35)
                .addComponent(reprovadojRadioButton)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aprovadojRadioButton)
                    .addComponent(reprovadojRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
         this.dispose();
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        if(aprovadojRadioButton.isSelected() || reprovadojRadioButton.isSelected() ){
            String status = aprovadojRadioButton.isSelected() ? "aprovado" : "reprovado";
            MovimentoAcademicoController movimentoController = new MovimentoAcademicoController();
            movimento.setSituacao(status);
            if(movimentoController.salvar(movimento) != null) {
                JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso"); 
                telaMovimentos.setModel();
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma opção!!"); 
            telaMovimentos.setModel();
        }
    }

}
