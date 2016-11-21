package telas.inicial;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import telas.aluno.FrmConsAluno;
import telas.curso.FrmConsCurso;
import telas.disciplina.FrmConsDisciplina;
import telas.movimentoAcademico.FrmMovimentoAcademico;
import telas.relatorios.FrmGerarRelatorios;
import telas.turma.FrmConsTurma;
import telas.usuario.UsuarioLogadoBean;

/**
 *
 * @author Kamila
 */
public class FrmInicial extends javax.swing.JFrame {

    private UsuarioLogadoBean usuarioLogadoBean;
    private JButton btnAluno, btnCurso, btnDisciplina1, btnNovo, btnSituacao, btnTrocarSenha, btnTurma1;
    private JMenu jMenu1, jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem4,jMenuItem5,jMenuItem6,jMenuItem7;
    private JPanel jPanel1,jPanel2;
    private JRadioButtonMenuItem jRadioButtonMenuItem1;
    private JSeparator jSeparator1;
    private JLabel lblLogoSysTM, lblNomeUsuario;
     
    public FrmInicial() { 
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        usuarioLogadoBean= new UsuarioLogadoBean();
        new FrmLogin(this, true, usuarioLogadoBean, lblNomeUsuario);
    }

    
    @SuppressWarnings("unchecked") 
    private void initComponents() {
        
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        btnNovo = new javax.swing.JButton();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnCurso = new javax.swing.JButton();
        btnAluno = new javax.swing.JButton();
        btnSituacao = new javax.swing.JButton();
        btnTurma1 = new javax.swing.JButton();
        btnDisciplina1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnTrocarSenha = new javax.swing.JButton();
        lblNomeUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        lblLogoSysTM = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(null);
        btnNovo.setBorderPainted(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setPreferredSize(new java.awt.Dimension(80, 90));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM); 

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTEC");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(0));

        lblLogoSysTM.setBackground(new java.awt.Color(247, 248, 247));
        lblLogoSysTM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoSysTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/senai.png"))); // NOI18N

        btnCurso.setBackground(new java.awt.Color(255, 255, 255));
        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaocurso.png"))); // NOI18N
        btnCurso.setToolTipText("Cursos");
        btnCurso.setBorder(null);
        btnCurso.setBorderPainted(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setPreferredSize(new java.awt.Dimension(80, 90));
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });

        btnAluno.setBackground(new java.awt.Color(255, 255, 255));
        btnAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoaluno.png"))); // NOI18N
        btnAluno.setToolTipText("Alunos");
        btnAluno.setBorder(null);
        btnAluno.setBorderPainted(false);
        btnAluno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAluno.setPreferredSize(new java.awt.Dimension(80, 90));
        btnAluno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoActionPerformed(evt);
            }
        });

        btnSituacao.setBackground(new java.awt.Color(255, 255, 255));
        btnSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosituacao.png"))); // NOI18N
        btnSituacao.setToolTipText("Situação de Alunos por Turma");
        btnSituacao.setBorder(null);
        btnSituacao.setBorderPainted(false);
        btnSituacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSituacao.setPreferredSize(new java.awt.Dimension(80, 90));
        btnSituacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSituacaoActionPerformed(evt);
            }
        });

        btnTurma1.setBackground(new java.awt.Color(255, 255, 255));
        btnTurma1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoturma.png"))); // NOI18N
        btnTurma1.setToolTipText("Turmas");
        btnTurma1.setBorder(null);
        btnTurma1.setBorderPainted(false);
        btnTurma1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma1.setPreferredSize(new java.awt.Dimension(80, 90));
        btnTurma1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTurma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurma1ActionPerformed(evt);
            }
        });

        btnDisciplina1.setBackground(new java.awt.Color(255, 255, 255));
        btnDisciplina1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaodisciplina.png"))); // NOI18N
        btnDisciplina1.setToolTipText("Disciplina");
        btnDisciplina1.setBorder(null);
        btnDisciplina1.setBorderPainted(false);
        btnDisciplina1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina1.setPreferredSize(new java.awt.Dimension(80, 90));
        btnDisciplina1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDisciplina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplina1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(244, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTrocarSenha.setBackground(new java.awt.Color(255, 255, 255));
        btnTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/configuration.png"))); // NOI18N
        btnTrocarSenha.setToolTipText("Trocar Senha");
        btnTrocarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocarSenhaActionPerformed(evt);
            }
        });

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(0, 51, 0));
        lblNomeUsuario.setText("Usuario  :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnTrocarSenha))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeUsuario)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTrocarSenha))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 403, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLogoSysTM, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTurma1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDisciplina1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogoSysTM, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTurma1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDisciplina1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        URL url = this.getClass().getResource("/imagens/iconSysTEC.png");  
        Image iconSysTEC = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(iconSysTEC);
        
        jMenuBar1.setBackground(new java.awt.Color(0, 51, 0));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(0, new java.awt.Color(0, 51, 0), new java.awt.Color(0, 51, 0), new java.awt.Color(0, 51, 0), new java.awt.Color(0, 51, 0)));
        jMenuBar1.setForeground(new java.awt.Color(0, 51, 0));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(0, 51, 0));
        jMenu1.setText("Cadastros");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 51, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menualuno.png"))); // NOI18N
        jMenuItem1.setText("Aluno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menucurso.png"))); // NOI18N
        jMenuItem2.setText("Curso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menudisciplina.png"))); // NOI18N
        jMenuItem3.setText("Disciplina");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menuturma.png"))); // NOI18N
        jMenuItem4.setText("Turma");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menuchapeu.png"))); // NOI18N
        jMenuItem5.setText("Movimento Academico");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 51, 0));
        jMenu2.setText("Relátorio");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Relatório");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsAluno();
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsCurso();
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
         new FrmConsTurma();
    }

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {
       new FrmGerarRelatorios();
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt){
        new FrmConsDisciplina();
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmMovimentoAcademico();
    }

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsCurso();
    }

    private void btnAlunoActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsAluno();
    }

    private void btnSituacaoActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmMovimentoAcademico();
    }

    private void btnTurma1ActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsTurma();
    }

    private void btnDisciplina1ActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmConsDisciplina();
    }

    private void btnTrocarSenhaActionPerformed(java.awt.event.ActionEvent evt) {
        new FrmAlterarSenha(usuarioLogadoBean.getUsuario());
    }

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
         new FrmGerarRelatorios();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicial().setVisible(true);
            }
        });
    }
 
}
