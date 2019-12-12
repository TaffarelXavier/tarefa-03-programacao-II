/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classesestaticas.ProfessorStatic;
import controllers.ProfessorController;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import modelos.Professor;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class TelaProfessor extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastrarProfessor
     */
    public TelaProfessor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherDadosNaTabela();
    }

    /**
     *
     */
    class ClientsTableButtonRenderer extends JButton implements TableCellRenderer {

        public ClientsTableButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setForeground(Color.black);
            setBackground(UIManager.getColor("Button.background"));
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ClientsTableRenderer extends DefaultCellEditor {

        private JButton button;
        private String label;
        private boolean clicked;
        private int row, col;
        private JTable table;

        public ClientsTableRenderer(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            this.row = row;
            this.col = column;

            button.setForeground(Color.black);
            button.setBackground(UIManager.getColor("Button.background"));
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            clicked = true;
            return button;
        }

        @Override
        /**
         * Para excluir algum registro:
         */
        public Object getCellEditorValue() {
            if (clicked) {
                int professorId = (int) table.getValueAt(row, 0);
                String nome = table.getValueAt(row, 1).toString();
                System.out.println(professorId);
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null,
                        "Deseja excluir este professor: " + nome + "?",
                        "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);
                if (n == JOptionPane.YES_OPTION) {
                    ProfessorController.excluir(professorId);
                }
            }
            clicked = false;
            return new String(label);
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    void preencherDadosNaTabela() {

        String[] columnNames = {"ID", "NOME", "CPF", "STATUS", "OPÇÃO"};

        try {
            Professor professores[] = ProfessorController.listarTudo();

            Object[][] data = new Object[professores.length][5]; //O 2, aqui, é a quantidade de colunas

            int index = 0;

            for (Professor s : professores) {
                data[index][0] = s.getId(); //
                data[index][1] = s.getNome(); //
                data[index][2] = s.getCPF(); //
                data[index][3] = s.getStatus(); //
                data[index][4] = "Excluir"; //
                index++;
            }

            TableModel model = new DefaultTableModel(data, columnNames) {
                private static final long serialVersionUID = 1L;

                public boolean isCellEditable(int row, int column) {
                    return column == 4 || column == 5;
                }
            };

            jTableProfessor.setModel(model);

            //Cria os botões:
            jTableProfessor.getColumnModel().getColumn(4).setCellRenderer(new TelaProfessor.ClientsTableButtonRenderer());
            jTableProfessor.getColumnModel().getColumn(4).setCellEditor(new TelaProfessor.ClientsTableRenderer(new JCheckBox()));
            jTableProfessor.setPreferredScrollableViewportSize(jTableProfessor.getPreferredSize());
            jTableProfessor.setShowHorizontalLines(true);
            jTableProfessor.setShowVerticalLines(false);

        } catch (Exception ex) {
            Logger.getLogger(TelaCursos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfessor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módulo: Professor");

        jTableProfessor.setAutoCreateRowSorter(true);
        jTableProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "STATUS"
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
        jTableProfessor.setToolTipText("Dê um duplo clique para alterar algum dado.");
        jTableProfessor.setRowHeight(30);
        jTableProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProfessorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableProfessorMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProfessor);
        if (jTableProfessor.getColumnModel().getColumnCount() > 0) {
            jTableProfessor.getColumnModel().getColumn(0).setMinWidth(100);
            jTableProfessor.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProfessor.getColumnModel().getColumn(1).setMinWidth(200);
            jTableProfessor.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableProfessor.getColumnModel().getColumn(2).setMinWidth(100);
            jTableProfessor.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem de Professores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Novo Professor");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Para alterar algum registro, dê um duplo clique sobre alguma linha.");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProfessorMouseClicked
        //Pega o  index da Tabela ao clicar sobre ela:
        int rowIndex = jTableProfessor.convertRowIndexToModel(jTableProfessor.getSelectedRow());
        //Pega o modelo da tabela
        TableModel model = jTableProfessor.getModel();
        //Pega o Id da linha selecionada:
        int id = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
        //Pega o nome da linha selecionada:
        String nome = model.getValueAt(rowIndex, 1).toString();

        String CPF = model.getValueAt(rowIndex, 2).toString();

        String status = model.getValueAt(rowIndex, 3).toString();

        ProfessorStatic.setId(id);
        ProfessorStatic.setCPF(CPF);
        ProfessorStatic.setNome(nome);
        ProfessorStatic.setStatus(status);
        ProfessorStatic.setTipo("alterar");

        if (evt.getClickCount() == 2) {
            TelaProfessorEditar telaProfEditar = new TelaProfessorEditar(null, rootPaneCheckingEnabled);
            telaProfEditar.setVisible(true);
        }
    }//GEN-LAST:event_jTableProfessorMouseClicked

    private void jTableProfessorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProfessorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProfessorMouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ProfessorStatic.setTipo("incluir");//Para alterar o tipo: incluir ou editar
        TelaProfessorEditar telaProfEditar = new TelaProfessorEditar(null, rootPaneCheckingEnabled);
        telaProfEditar.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProfessor dialog = new TelaProfessor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfessor;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
