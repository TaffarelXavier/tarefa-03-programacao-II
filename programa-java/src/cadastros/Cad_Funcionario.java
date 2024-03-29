/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import controllers.FuncionarioController;
import javax.swing.JOptionPane;
import modelos.Funcionario;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Cad_Funcionario extends javax.swing.JDialog {

    private boolean isEditando = false;

    private int funcionarioId = 0;

    /**
     *
     * @param funcionario
     * @param parent
     * @param modal
     */
    public Cad_Funcionario(Object[] funcionario, java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        if (funcionario != null) {

            isEditando = true;

            //Instancianção da classe:
            Funcionario func = FuncionarioController.getDadosPorIdFuncionaio(Integer.parseInt(funcionario[0].toString()));

            jTextField_Nome.setText(func.getNome());

            jTextField_CPF.setText(func.getCpf());

            jTextField_Cargo.setText(func.getCargo());

            jComboBox_Nivel.setSelectedItem(func.getNivel());

            jCheckBox_PermitirLogin.setSelected(func.isPermitirLogin());

            jPasswordField_Senha.setText(func.getSenha());

            funcionarioId = func.getId();
        } else {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButtonExcluirDisciplina = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelDisc_Id = new javax.swing.JLabel();
        jTextField_Nome = new javax.swing.JTextField();
        jTextField_CPF = new javax.swing.JTextField();
        jLabelDisciplina1 = new javax.swing.JLabel();
        jLabelDisciplina2 = new javax.swing.JLabel();
        jComboBox_Nivel = new javax.swing.JComboBox<>();
        jLabelDisciplina3 = new javax.swing.JLabel();
        jTextField_Cargo = new javax.swing.JTextField();
        jLabelDisciplina4 = new javax.swing.JLabel();
        jCheckBox_PermitirLogin = new javax.swing.JCheckBox();
        jPasswordField_Senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton3.setBackground(new java.awt.Color(51, 153, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save-icon.png"))); // NOI18N
        jButton3.setText("SALVAR");
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonExcluirDisciplina.setBackground(new java.awt.Color(255, 51, 51));
        jButtonExcluirDisciplina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonExcluirDisciplina.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluirDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trash-icon.png"))); // NOI18N
        jButtonExcluirDisciplina.setText("EXCLUIR");
        jButtonExcluirDisciplina.setContentAreaFilled(false);
        jButtonExcluirDisciplina.setOpaque(true);
        jButtonExcluirDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(jButtonExcluirDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluirDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRAR FUNCIONÁRIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabelDisc_Id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDisc_Id.setText("NOME:");

        jTextField_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelDisciplina1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDisciplina1.setText("CPF:");

        jLabelDisciplina2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDisciplina2.setText("SENHA:");

        jComboBox_Nivel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_Nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BASICO", "MEDIO", "AVANCADO" }));

        jLabelDisciplina3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDisciplina3.setText("NÍVEL:");

        jTextField_Cargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelDisciplina4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDisciplina4.setText("CARGO:");

        jCheckBox_PermitirLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox_PermitirLogin.setText("PERMITIR LOGIN NO SISTEMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDisc_Id)
                    .addComponent(jLabelDisciplina1)
                    .addComponent(jLabelDisciplina2)
                    .addComponent(jLabelDisciplina3)
                    .addComponent(jLabelDisciplina4)
                    .addComponent(jTextField_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox_PermitirLogin))
                    .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDisc_Id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDisciplina1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDisciplina4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabelDisciplina2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabelDisciplina3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_PermitirLogin))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void incluir(String nome, String cpf, String senha, String nivel, String cargo, boolean permitirLogin) {
        if (FuncionarioController.incluir(nome, cpf, senha, nivel, cargo, permitirLogin) > 0) {
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com suceso!", "Sucesso!", 1);
        }
    }

    void alterar(String nome, String cpf, String senha, String nivel, String cargo, boolean permitirLogin) {
        System.out.println(this.funcionarioId);
        if (FuncionarioController.alterar(nome, cpf, senha, nivel, cargo, permitirLogin, this.funcionarioId) > 0) {
            JOptionPane.showMessageDialog(null, "Os dados do funcionário foi alterado com suceso!", "Sucesso!", 1);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nome = jTextField_Nome.getText().toUpperCase().trim();
        String cpf = jTextField_CPF.getText().toUpperCase().trim().replaceAll("\\-", "").replaceAll("\\.", "");
        String senha = new String(jPasswordField_Senha.getPassword());
        String cargo = jTextField_Cargo.getText().toUpperCase().trim();
        boolean permitirLogin = jCheckBox_PermitirLogin.isSelected();
        String nivel = jComboBox_Nivel.getSelectedItem().toString().toUpperCase().trim();

        if (nome.length() > 0
                && cpf.length() > 0
                && senha.length() > 0
                && cargo.length() > 0
                && nivel.length() > 0) {
            if (isEditando == true) {
                //Edição
                alterar(nome, cpf, senha, nivel, cargo, permitirLogin);
            } else {
                //Inclusão:
                incluir(nome, cpf, senha, nivel, cargo, permitirLogin);
                jTextField_Nome.setText("");
                jTextField_CPF.setText("");
                jPasswordField_Senha.setText("");
                jTextField_Cargo.setText("");
                jCheckBox_PermitirLogin.setSelected(false);
                jComboBox_Nivel.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "O nome do funcionário está vazio está vazio.", "Atenção", 1);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonExcluirDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirDisciplinaActionPerformed
//
//        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta disciplina?", "Cuidado!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (dialogResult == JOptionPane.YES_OPTION) {
//            // Saving code here
//            int disciplinaID = Integer.parseInt(jTextFieldId.getText());
//            if (DisciplinaController.excluir(disciplinaID) > 0) {
//                JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso!",
//                    "Sucesso!", 1);
//                this.setVisible(false);
//            }
//        }
    }//GEN-LAST:event_jButtonExcluirDisciplinaActionPerformed

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
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cad_Funcionario dialog = new Cad_Funcionario(null, new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonExcluirDisciplina;
    private javax.swing.JCheckBox jCheckBox_PermitirLogin;
    private javax.swing.JComboBox<String> jComboBox_Nivel;
    private javax.swing.JLabel jLabelDisc_Id;
    private javax.swing.JLabel jLabelDisciplina1;
    private javax.swing.JLabel jLabelDisciplina2;
    private javax.swing.JLabel jLabelDisciplina3;
    private javax.swing.JLabel jLabelDisciplina4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField_Senha;
    private javax.swing.JTextField jTextField_CPF;
    private javax.swing.JTextField jTextField_Cargo;
    private javax.swing.JTextField jTextField_Nome;
    // End of variables declaration//GEN-END:variables
}
