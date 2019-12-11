/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import cadastros.TelaAlunoIncluirEditar;
import java.awt.Color;

/**
 *
 * @author ancelmocastro
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();

        //executar a tela maximizada...
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(244, 246, 246));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbCursos = new javax.swing.JButton();
        jbAluno = new javax.swing.JButton();
        jbMatricula = new javax.swing.JButton();
        jbMatricula1 = new javax.swing.JButton();
        jbMatricula2 = new javax.swing.JButton();
        jbMatricula3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento Escolar");
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBackground(new java.awt.Color(116, 207, 112));

        jbCursos.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbCursos.setForeground(new java.awt.Color(102, 102, 255));
        jbCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Certificate-icon.png"))); // NOI18N
        jbCursos.setText("Cadastrar Cursos");
        jbCursos.setToolTipText("Realiza cadastros de Cursos");
        jbCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCursos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCursos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCursosActionPerformed(evt);
            }
        });

        jbAluno.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbAluno.setForeground(new java.awt.Color(102, 102, 255));
        jbAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Student-id-icon.png"))); // NOI18N
        jbAluno.setText("Cadastrar Aluno");
        jbAluno.setToolTipText("Realiza cadastros de Alunos");
        jbAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAluno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAluno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlunoActionPerformed(evt);
            }
        });

        jbMatricula.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbMatricula.setForeground(new java.awt.Color(102, 102, 255));
        jbMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Teacher-male-icon.png"))); // NOI18N
        jbMatricula.setText("Gerenciar Alunos");
        jbMatricula.setToolTipText("Realiza matrículas de Alunos cadastrados");
        jbMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMatricula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMatricula.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatriculaActionPerformed(evt);
            }
        });

        jbMatricula1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbMatricula1.setForeground(new java.awt.Color(102, 102, 255));
        jbMatricula1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Science-Classroom-icon.png"))); // NOI18N
        jbMatricula1.setText("Turmas");
        jbMatricula1.setToolTipText("Realiza matrículas de Alunos cadastrados");
        jbMatricula1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMatricula1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMatricula1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMatricula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatricula1ActionPerformed(evt);
            }
        });

        jbMatricula2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbMatricula2.setForeground(new java.awt.Color(102, 102, 255));
        jbMatricula2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Books-icon.png"))); // NOI18N
        jbMatricula2.setText("Disciplinas");
        jbMatricula2.setToolTipText("Realiza matrículas de Alunos cadastrados");
        jbMatricula2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMatricula2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMatricula2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMatricula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatricula2ActionPerformed(evt);
            }
        });

        jbMatricula3.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jbMatricula3.setForeground(new java.awt.Color(102, 102, 255));
        jbMatricula3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/professor-icone.png"))); // NOI18N
        jbMatricula3.setText("Professor");
        jbMatricula3.setToolTipText("Realiza matrículas de Alunos cadastrados");
        jbMatricula3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMatricula3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMatricula3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMatricula3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatricula3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMatricula2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMatricula3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbMatricula2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMatricula1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCursos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jbAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMatricula3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/a4a4781ea9a21bad74cb8a535c471ce22652424b.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SME - SISTEMA MODULAR ESCOLAR");

        jMenu1.setText("Sistema");

        jMenu5.setText("Transações");

        jMenuItem1.setText("Cadastrar Cursos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setText("Cadastrar Aluno");
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Cadastrar Turmas");
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("Cadastrar Professores");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Cadastrar Disciplinas");
        jMenu5.add(jMenuItem5);
        jMenu5.add(jSeparator1);

        jMenuItem6.setText("Matricular Aluno");
        jMenu5.add(jMenuItem6);

        jMenu1.add(jMenu5);
        jMenu1.add(jSeparator2);

        jMenuItem7.setText("Sair");
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        jMenuItem8.setText("Aluno");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Cursos");
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Professores");
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ajuda");

        jMenuItem11.setText("Sobre...");
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Para abrir telas
     *
     * @param tela
     */
    public void abrirTela(javax.swing.JDialog tela) {
        tela.setVisible(true);
    }


    private void jbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCursosActionPerformed
        // TODO add your handling code here:
        abrirTela(new TelaCursos(this, rootPaneCheckingEnabled));
    }//GEN-LAST:event_jbCursosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jbCursos.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlunoActionPerformed
        // TODO add your handling code here:
        new TelaAlunoIncluirEditar(null, rootPaneCheckingEnabled, "incluir").setVisible(true);
    }//GEN-LAST:event_jbAlunoActionPerformed

    private void jbMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMatriculaActionPerformed
        // TODO add your handling code here:
        abrirTela(new TelaAlunoGerenciar(this, rootPaneCheckingEnabled));
    }//GEN-LAST:event_jbMatriculaActionPerformed

    private void jbMatricula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMatricula1ActionPerformed
        // TODO add your handling code here:
        abrirTela(new TelaTurma(this, rootPaneCheckingEnabled));
    }//GEN-LAST:event_jbMatricula1ActionPerformed

    private void jbMatricula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMatricula2ActionPerformed
        // TODO add your handling code here:
        abrirTela(new TelaDisciplina(this, rootPaneCheckingEnabled));
    }//GEN-LAST:event_jbMatricula2ActionPerformed

    private void jbMatricula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMatricula3ActionPerformed
        // TODO add your handling code here:
        abrirTela(new TelaProfessor(this, rootPaneCheckingEnabled));
    }//GEN-LAST:event_jbMatricula3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jbAluno;
    private javax.swing.JButton jbCursos;
    private javax.swing.JButton jbMatricula;
    private javax.swing.JButton jbMatricula1;
    private javax.swing.JButton jbMatricula2;
    private javax.swing.JButton jbMatricula3;
    // End of variables declaration//GEN-END:variables
}
