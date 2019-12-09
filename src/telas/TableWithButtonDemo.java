/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TableWithButtonDemo {

    private JFrame frame = new JFrame("Table Demo");

    private String[] columnNames = {"String", "Integer", "Float", "", "Opção"};

    private Object[][] data = {
        {"Dummy", new Integer(12), new Float(12.15), "Consulter", "excluir"},
        {"Dummy", new Integer(120), new Float(12.15), "Consulter", "excluir"},
        {"Dummy", new Integer(10), new Float(12.15), "Consulter", "excluir"}
    };

    private TableModel model = new DefaultTableModel(data, columnNames) {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {
            return column == 3 || column == 4;
        }
    };

    private JTable table = new JTable(model);

    public TableWithButtonDemo() {
        //Cria os botões
        table.getColumnModel().getColumn(3).setCellRenderer(new ClientsTableButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ClientsTableRenderer(new JCheckBox()));

        table.getColumnModel().getColumn(4).setCellRenderer(new ClientsTableButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ClientsTableRenderer(new JCheckBox()));

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);

        JScrollPane scroll = new JScrollPane(table); //Adiciona a tabela ao JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scroll);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableWithButtonDemo();
            }
        });
    }

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
        public Object getCellEditorValue() {
            if (clicked) {
                JOptionPane.showMessageDialog(button, "Column with Value: " + table.getValueAt(row, 1) + " -  Clicked!");
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

}
