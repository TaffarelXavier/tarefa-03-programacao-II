/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import cadastros.Cad_Aluno;
import classesestaticas.AlunoStatico;
import controllers.AlunoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Aluno;

//Atualizar  a data da matrícula e o id do curso na tabela do aluno e salvar os ids das disciplinas em uma nova tabela.
/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class Cons_Aluno extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastrarAluno
     */
    public Cons_Aluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherDadosNaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAluno = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jtCursoNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonPesquisarAluno = new javax.swing.JButton();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo: Alunos");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTableAluno.setAutoCreateRowSorter(true);
        jTableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "DATA DE NASCIMENTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAluno.setRowHeight(30);
        jTableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlunoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableAlunoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAluno);
        if (jTableAluno.getColumnModel().getColumnCount() > 0) {
            jTableAluno.getColumnModel().getColumn(0).setMinWidth(50);
            jTableAluno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableAluno.getColumnModel().getColumn(1).setMinWidth(200);
            jTableAluno.getColumnModel().getColumn(1).setMaxWidth(250);
            jTableAluno.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MÓDULO ALUNO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add-icon.png"))); // NOI18N
        jButton1.setText("NOVO ALUNO");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar aluno(s):");

        jButtonPesquisarAluno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPesquisarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search-icon-32.png"))); // NOI18N
        jButtonPesquisarAluno.setText("PESQUISAR");
        jButtonPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarAlunoActionPerformed(evt);
            }
        });

        jComboBoxFiltro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "ID", "Data de Nascimento" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Filtro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCursoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCursoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dê um duplo clique para poder excluir ou editar algum registro.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunoMouseClicked
        //Pega o  index da Tabela ao clicar sobre ela:
        int rowIndex = jTableAluno.convertRowIndexToModel(jTableAluno.getSelectedRow());
        //Pega o modelo da tabela
        TableModel model = jTableAluno.getModel();
        //Pega o Id da linha selecionada:
        int id = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
        //Pega o nome da linha selecionada:
        String nome = model.getValueAt(rowIndex, 1).toString();

        String cpf = model.getValueAt(rowIndex, 2).toString();

        String dataNascimento = model.getValueAt(rowIndex, 3).toString();

        AlunoStatico.setTipoDeAcao("alteracao");
        AlunoStatico.setCodigoAluno(id);
        AlunoStatico.setNome(nome);
        AlunoStatico.setCPF(cpf);
        AlunoStatico.setDataDeNascimento(dataNascimento);

        if (evt.getClickCount() > 1) {
            new Cad_Aluno(null, true, "editar").setVisible(true);
        }

    }//GEN-LAST:event_jTableAlunoMouseClicked

    private void jTableAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableAlunoMouseEntered
    /**
     * Preenche a tabela (jTable1) com os dados de cursos vindo do banco de dados
     */

    void preencherDadosNaTabela() {

        String[] columnNames = {"ID", "NOME", "CPF", "DATA DE NASCIMENTO"};

        try {
            Aluno alunos[] = AlunoController.listarTodos();

            Object[][] data = new Object[alunos.length][4]; //O 2, aqui, é a quantidade de colunas

            int index = 0;

            for (Aluno s : alunos) {
                data[index][0] = s.getCodigoAluno(); //
                data[index][1] = s.getNome(); //
                data[index][2] = s.getCPF(); //
                data[index][3] = s.getDataDeNascimento(); //
                index++;
            }

            TableModel model = new DefaultTableModel(data, columnNames) {
                private static final long serialVersionUID = 1L;

                public boolean isCellEditable(int row, int column) {
                    return column < -1;
                }
            };

            jTableAluno.setModel(model);

        } catch (Exception ex) {
            Logger.getLogger(Cons_Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void filtrarDados() {

        String[] columnNames = {"ID", "NOME", "CPF", "DATA DE NASCIMENTO"};

        try {
            String filtro = jtCursoNome.getText();

            String filtroTipo = jComboBoxFiltro.getSelectedItem().toString().toLowerCase();

            Aluno alunos[] = AlunoController.filtrarDadosAluno(filtro, filtroTipo);

            Object[][] data = new Object[alunos.length][4]; //O 2, aqui, é a quantidade de colunas

            int index = 0;

            for (Aluno s : alunos) {
                data[index][0] = s.getCodigoAluno(); //
                data[index][1] = s.getNome(); //
                data[index][2] = s.getCPF(); //
                data[index][3] = s.getDataDeNascimento(); //
                index++;
            }

            TableModel model = new DefaultTableModel(data, columnNames) {
                private static final long serialVersionUID = 1L;

                public boolean isCellEditable(int row, int column) {
                    return column < -1;
                }
            };

            jTableAluno.setModel(model);

        } catch (Exception ex) {
            Logger.getLogger(Cons_Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Cad_Aluno(null, rootPaneCheckingEnabled, "incluir").setVisible(true);
//        String nomeDoAluno = jtCursoNome.getText().trim();
//        if (nomeDoAluno.length() > 0) {
//           /*if (AlunoController.incluir(nomeDoAluno) > 0) {
//                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
//                preencherDadosNaTabela();
//                jtCursoNome.setText("");
//            } else {
//                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o aluno, tente novamente!");
//            }*/
//        } else {
//            JOptionPane.showMessageDialog(null, "Nome do aluno inválido ou em branco.");
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:

        preencherDadosNaTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButtonPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAlunoActionPerformed
        // TODO add your handling code here:
        filtrarDados();
    }//GEN-LAST:event_jButtonPesquisarAlunoActionPerformed

    private void jtCursoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCursoNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            jButtonPesquisarAluno.doClick();
        }
    }//GEN-LAST:event_jtCursoNomeKeyPressed

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
            java.util.logging.Logger.getLogger(Cons_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cons_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cons_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cons_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cons_Aluno dialog = new Cons_Aluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPesquisarAluno;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAluno;
    private javax.swing.JTextField jtCursoNome;
    // End of variables declaration//GEN-END:variables
}