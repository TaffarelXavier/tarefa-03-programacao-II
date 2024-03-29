/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import cadastros.Cad_Funcionario;
import controllers.FuncionarioController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Funcionario;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Cons_Funcionario extends javax.swing.JDialog {

    /**
     * Creates new form Cons_Funcionario
     */
    public Cons_Funcionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buscarFuncionarios();
    }

    void buscarFuncionarios() {

        String[] columnNames = {"ID", "NOME", "CPF", "NÍVEL", "CARGO", "PERMITIR LOGIN"};

        try {
            Funcionario alunos[] = FuncionarioController.listarTodos();

            Object[][] data = new Object[alunos.length][6]; //O 6, aqui, é a quantidade de colunas

            int index = 0;

            for (Funcionario s : alunos) {
                data[index][0] = s.getId(); //
                data[index][1] = s.getNome(); //
                data[index][2] = s.getCpf(); //
                data[index][3] = s.getNivel(); //
                data[index][4] = s.getCargo(); //
                data[index][5] = s.isPermitirLogin(); //
                index++;
            }

            TableModel model = new DefaultTableModel(data, columnNames) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column < -1;
                }
            };

            jTableFuncionarios.setModel(model);

        } catch (Exception ex) {
            Logger.getLogger(Cons_Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jtCursoNome = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxFiltroTurma = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTableFuncionarios.setAutoCreateRowSorter(true);
        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "NIVEL", "CARGO", "FAZ LOGIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFuncionarios.setRowHeight(30);
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MÓDULO FUNCIONÁRIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add-icon.png"))); // NOI18N
        jButton1.setText("NOVO FUNCIONÁRIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtCursoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCursoNomeKeyPressed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search-icon-32.png"))); // NOI18N
        jButtonPesquisar.setText("PESQUISAR");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBoxFiltroTurma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxFiltroTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "SALA", "CAPACIDADE", "BLOCO" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Filtro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jtCursoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxFiltroTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtCursoNome)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFiltroTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked
        //Pega o  index da Tabela ao clicar sobre ela:

        int rowIndex = jTableFuncionarios.convertRowIndexToModel(jTableFuncionarios.getSelectedRow());
        //Pega o modelo da tabela
        TableModel model = jTableFuncionarios.getModel();
        //Pega o Id da linha selecionada:
        int id = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());

        Object obj[] = new Object[2];

        obj[0] = id;

        if (evt.getClickCount() > 1) {
            new cadastros.Cad_Funcionario(obj, null, true).setVisible(true);
        }
    }//GEN-LAST:event_jTableFuncionariosMouseClicked

    private void jTableFuncionariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableFuncionariosMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        String nomeDoAluno = jtCursoNome.getText().trim();
        //        if (nomeDoAluno.length() > 0) {
        //            if (AlunoController.incluirNovoAluno(nomeDoAluno) > 0) {
        //                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        //                preencherDadosNaTabela();
        //                jtCursoNome.setText("");
        //            } else {
        //                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o aluno, tente novamente!");
        //            }
        //        } else {
        //            JOptionPane.showMessageDialog(null, "Nome do aluno inválido ou em branco.");
        //        }

        new Cad_Funcionario(null, null, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtCursoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCursoNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            jButtonPesquisar.doClick();
        }
    }//GEN-LAST:event_jtCursoNomeKeyPressed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        String[] columnNames = {"ID", "SALA", "CAPACIDADE", "TURNO", "BLOCO", "PERÍODO LETIVO", "ANO LETIVO"};

//        try {
//
//            String filtro = jtCursoNome.getText();
//            String filtroTipo = jComboBoxFiltroTurma.getSelectedItem().toString().toLowerCase();
//
//            Turma turmas[] = TurmaController.filtrarTurma(filtro, filtroTipo);
//
//            if (turmas != null) {
//
//                Object[][] data = new Object[turmas.length][7]; //O 2, aqui, é a quantidade de colunas
//
//                int index = 0;
//
//                for (Turma turm : turmas) {
//                    data[index][0] = turm.getTurmaID(); //
//                    data[index][1] = turm.getSala(); //
//                    data[index][2] = turm.getCapacidade(); //
//                    data[index][3] = turm.getTurno().toUpperCase(); //
//                    data[index][4] = turm.getBloco(); //
//                    data[index][5] = turm.getPeriodLetivo(); //
//                    data[index][6] = turm.getAnoLetivo(); //
//                    index++;
//                }
//
//                DefaultTableModel modelo = new DefaultTableModel(data, columnNames) {
//                    //método que impede o modo de edição na Tabela....
//                    @Override
//                    public boolean isCellEditable(int linhas, int colunas) {
//                        return colunas == -1;
//                    }
//                };
//
//                jTableTurma.setModel(modelo);
//
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(Cons_Cursos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        buscarFuncionarios();
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(Cons_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cons_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cons_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cons_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Cons_Funcionario dialog = new Cons_Funcionario(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxFiltroTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jtCursoNome;
    // End of variables declaration//GEN-END:variables
}
