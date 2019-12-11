/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import classesestaticas.AlunoStatico;
import controllers.AlunoController;
import controllers.AlunoDisciplinaController;
import controllers.CursoController;
import controllers.DisciplinaController;
import controllers.MatriculaController;
import controllers.ProfessorController;
import controllers.TurmaController;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Aluno;
import modelos.AlunoDisciplina;
import modelos.AlunoMatricula;
import modelos.Curso;
import modelos.Disciplina;
import modelos.Turma;
import servicos.ComboItem;
import servicos.Funcoes;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class TelaAlunoIncluirEditar extends javax.swing.JDialog {

    private int alunoID = 0;
    private String acao;
    private boolean isMatricular = false;

    /**
     *
     * @param parent
     * @param modal
     * @param aAcao
     */
    public TelaAlunoIncluirEditar(java.awt.Frame parent, boolean modal, String aAcao) {

        super(parent, modal);

        initComponents();

        this.alunoID = AlunoStatico.getCodigoAluno();

        mostrarMatriculas();

        acao = aAcao; //Se é inclusão ou edição

        try {
            if (acao.equals("editar")) { //Editar Aluno

                Aluno aluno[] = AlunoController.getDadosPorAlunoId(alunoID);

                jTextFieldNome.setText(aluno[0].getNome());

                jTextFieldCPF.setText(aluno[0].getCPF());

                jTextFieldTelefone.setText(aluno[0].getTelefone());

                jTextFieldDataNascimento.setText(aluno[0].getDataDeNascimento());

                jTextFieldEmail.setText(aluno[0].getEmail());

                jButtonExcluirAluno.setEnabled(true);

                jButtonMatricular.setEnabled(true);

                jButtonSalvarAlteracoes.setEnabled(true);

            } else {
                jTextFieldNome.setText("");

                jTextFieldCPF.setText("");

                jTextFieldTelefone.setText("");

                jTextFieldDataNascimento.setText("");

                jTextFieldEmail.setText("");

                alunoID = 0;
                DefaultTableModel model1 = (DefaultTableModel) jTableDisciplinas.getModel();
                model1.setRowCount(0);
                DefaultTableModel model2 = (DefaultTableModel) jTableMatriculas.getModel();
                model2.setRowCount(0);
                jButtonSalvarAlteracoes.setEnabled(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(Level.INFO, null, ex);
        }
    }

    void naoPermitirEdicaoJTable() {

        TableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableDisciplinas.setModel(model);
    }

    /**
     * Para permitir ou não edição de algum elemento
     *
     * @param permitir
     */
    void permitirEdicao(boolean permitir) {
        if (permitir) {
            jPanelMatricula.setEnabled(permitir);
            jTextFieldDataMatricula.setEnabled(permitir);
            jComboBoxCurso.setEnabled(permitir);
            jComboBoxDisciplinas.setEnabled(permitir);
            jTableDisciplinas.setEnabled(permitir);
            jComboBoxTurma.setEnabled(permitir);
            jComboBoxResultado.setEnabled(permitir);
            jTextFieldPeriodo.setEnabled(permitir);
            jTextFieldMedia.setEnabled(permitir);
        }
    }

    void mostrarMatriculas() {
        try {

            AlunoMatricula[] matriculas = MatriculaController.getMatriculaPorAluno(alunoID);

            if (matriculas != null) {

                String[] columnNames = {"ID", "CURSO", "DATA DA MATRÍCULA", "PERÍODO"};

                Object[][] data = new Object[matriculas.length][4]; //O 2, aqui, ? a quantidade de colunas

                int index = 0;

                for (AlunoMatricula matricula : matriculas) {
                    System.out.println(matricula.getNomecurso());
                    data[index][0] = matricula.getMatricula_id(); //
                    data[index][1] = matricula.getNomecurso(); //
                    data[index][2] = matricula.getData_matricula(); //
                    data[index][3] = matricula.getPeriodo_letivo(); //
                    index++;
                }

                TableModel model = new DefaultTableModel(data, columnNames) {
                    private static final long serialVersionUID = 1L;

                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                jTableMatriculas.setModel(model);
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMatricula = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDataMatricula = new javax.swing.JTextField();
        jComboBoxDisciplinas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisciplinas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCurso = new javax.swing.JComboBox<>();
        jLabelCurso_Id = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTurma = new javax.swing.JComboBox<>();
        jLabelTurma_Id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMatriculas = new javax.swing.JTable();
        jTextFieldPeriodo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldMedia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxResultado = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonSalvarAlteracoes = new javax.swing.JButton();
        jButtonMatricular = new javax.swing.JButton();
        jButtonExcluirAluno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanelMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanelMatricula.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data da Matrícula:");

        jTextFieldDataMatricula.setEnabled(false);

        jComboBoxDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxDisciplinas.setEnabled(false);
        jComboBoxDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDisciplinasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Disciplinas:");

        jTableDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TÍTULO DISCIPLINA"
            }
        ));
        jTableDisciplinas.setEnabled(false);
        jTableDisciplinas.setRowHeight(25);
        jTableDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisciplinas);
        if (jTableDisciplinas.getColumnModel().getColumnCount() > 0) {
            jTableDisciplinas.getColumnModel().getColumn(0).setMinWidth(50);
            jTableDisciplinas.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableDisciplinas.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Disciplinas para este aluno:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Curso:");

        jComboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxCurso.setEnabled(false);
        jComboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursoActionPerformed(evt);
            }
        });

        jLabelCurso_Id.setText("Curso ID");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Turma:");

        jComboBoxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxTurma.setEnabled(false);
        jComboBoxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurmaActionPerformed(evt);
            }
        });

        jLabelTurma_Id.setText("Turma ID");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Resultado:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Dê um duplo clique sobre algum registro para removê-lo.");

        jTableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "CURSO", "DATA DA MATRÍCULA", "PERÍODO"
            }
        ));
        jTableMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMatriculasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMatriculas);

        jTextFieldPeriodo.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Período Letivo:");

        jTextFieldMedia.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Média:");

        jComboBoxResultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprovado", "Reprovado" }));
        jComboBoxResultado.setEnabled(false);
        jComboBoxResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMatriculaLayout = new javax.swing.GroupLayout(jPanelMatricula);
        jPanelMatricula.setLayout(jPanelMatriculaLayout);
        jPanelMatriculaLayout.setHorizontalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(101, 101, 101)
                                .addComponent(jLabelCurso_Id)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelTurma_Id))
                                            .addComponent(jLabel11)
                                            .addComponent(jComboBoxResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17))
                                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                        .addComponent(jComboBoxTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldPeriodo)
                                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2)))
        );
        jPanelMatriculaLayout.setVerticalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabelTurma_Id)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabelCurso_Id))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatriculaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(11, 11, 11)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Básicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jTextFieldCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPFActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Telefone:");

        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Data de Nascimento:");

        jTextFieldDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Email:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(176, 176, 176)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButtonSalvarAlteracoes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalvarAlteracoes.setText("SALVAR");
        jButtonSalvarAlteracoes.setEnabled(false);
        jButtonSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteracoesActionPerformed(evt);
            }
        });

        jButtonMatricular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonMatricular.setText("MATRICULAR");
        jButtonMatricular.setEnabled(false);
        jButtonMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMatricularActionPerformed(evt);
            }
        });

        jButtonExcluirAluno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonExcluirAluno.setText("EXCLUIR ALUNO");
        jButtonExcluirAluno.setEnabled(false);
        jButtonExcluirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExcluirAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataNascimentoActionPerformed

    private void jTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPFActionPerformed

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jButtonSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracoesActionPerformed
        // TODO add your handling code here:

        String nome = jTextFieldNome.getText();

        String dataNascimento = jTextFieldDataNascimento.getText();

        String cpf = jTextFieldCPF.getText();

        String telefone = jTextFieldTelefone.getText();

        String email = jTextFieldEmail.getText();

        if (acao.equals("editar")) { //Alteração

            if (isMatricular) { //Caso o usuário tenha clicado em matricular:
                String dataMatricula = jTextFieldDataMatricula.getText();

                String resultado = jComboBoxResultado.getSelectedItem().toString();

                int cursoID = Integer.parseInt(jLabelCurso_Id.getText());

                int turmaId = Integer.parseInt(jLabelTurma_Id.getText());

                int periodoLetivoNumero = Integer.parseInt(jTextFieldPeriodo.getText());

                double media = Double.parseDouble(jTextFieldMedia.getText());

                int matriculaId = MatriculaController.incluir(this.alunoID, turmaId, media, cursoID, periodoLetivoNumero, dataMatricula, resultado);

                DefaultTableModel model = (DefaultTableModel) jTableDisciplinas.getModel();

                int nRow = model.getRowCount();

                //Pega os IDs das disciplinas:
                for (int i = 0; i < nRow; i++) {
                    AlunoDisciplinaController.incluir(this.alunoID, Integer.parseInt(model.getValueAt(i, 0).toString()), matriculaId);
                }
                mostrarMatriculas();
            }
            if (AlunoController.alterar(nome, dataNascimento, cpf, telefone, email, alunoID) > 0) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Info!", 1);
            }

        } else {
            //Inclusão

            if (AlunoController.incluir(nome, dataNascimento, cpf, telefone, email) > 0) {
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Aluno Cadastro com Sucesso!\n\nDeseja matricular este aluno agora?", "Atenção",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    permitirEdicao(true);
                }

            } else {

            }
        }


    }//GEN-LAST:event_jButtonSalvarAlteracoesActionPerformed

    private void jButtonMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMatricularActionPerformed
        try {
            //Dá focus 
            jTextFieldDataMatricula.requestFocus();
            jTextFieldDataMatricula.setText(Funcoes.getAtualDataDD_MM_YYYY());//preeche este campo com a data atual

            isMatricular = true;
            // Adiciona cursos ao combobox de cursos
            Curso cursos[] = CursoController.listarTudo();

            Vector model = new Vector();

            for (Curso curso : cursos) {
                model.addElement(new ComboItem(curso.getId(), curso.getNome()));
            }

            jComboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(model));
            //Fim

            // Adiciona Disciplinas ao combobox de Disciplinas
            Disciplina disciplinas[] = DisciplinaController.listarTudo();

            Vector vetorDisc = new Vector();

            for (Disciplina disciplina : disciplinas) {
                vetorDisc.addElement(new ComboItem(disciplina.getCodigoDisciplina(), disciplina.getTitulo()));
            }

            jComboBoxDisciplinas.setModel(new DefaultComboBoxModel<>(vetorDisc));
            //Fim

            // Adiciona Disciplinas ao combobox de Disciplinas
            Turma turmas[] = TurmaController.listarTudo();

            Vector modelTurma = new Vector();

            for (Turma turma : turmas) {
                String textoDisplay = turma.getCodigoSala() + "- Bloco " + turma.getBloco();
                modelTurma.addElement(new ComboItem(turma.getCodigoTurma(), textoDisplay));
            }

            jComboBoxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(modelTurma));
            //Fim

            permitirEdicao(true);
            //Limpar
            DefaultTableModel modelDisc = (DefaultTableModel) jTableDisciplinas.getModel();
            modelDisc.setRowCount(0);
        } catch (Exception ex) {
            Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMatricularActionPerformed

    private void jComboBoxDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDisciplinasActionPerformed
        // TODO add your handling code here:
        JComboBox comboBox = (JComboBox) evt.getSource();

        ComboItem item = (ComboItem) comboBox.getSelectedItem();

        DefaultTableModel model = (DefaultTableModel) jTableDisciplinas.getModel();

        model.addRow(new Object[]{item.getValue(), item.getLabel()});
    }//GEN-LAST:event_jComboBoxDisciplinasActionPerformed

    private void jComboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursoActionPerformed
        // TODO add your handling code here:
        JComboBox comboBox = (JComboBox) evt.getSource();

        ComboItem item = (ComboItem) comboBox.getSelectedItem();

        jLabelCurso_Id.setText(String.valueOf(item.getValue()));
    }//GEN-LAST:event_jComboBoxCursoActionPerformed

    private void jComboBoxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurmaActionPerformed
        // TODO add your handling code here:
        JComboBox comboBox = (JComboBox) evt.getSource();

        ComboItem item = (ComboItem) comboBox.getSelectedItem();

        jLabelTurma_Id.setText(String.valueOf(item.getValue()));
    }//GEN-LAST:event_jComboBoxTurmaActionPerformed

    private void jTableDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisciplinasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDisciplinasMouseClicked

    private void jButtonExcluirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirAlunoActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Deseja realmente remove este aluno da base de dados?", "Cuidado!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (AlunoController.excluir(alunoID) > 0) {
                JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o aluno, tente novamente!");
            }
        } else {
        }

    }//GEN-LAST:event_jButtonExcluirAlunoActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void jComboBoxResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxResultadoActionPerformed

    public TableModel setModel(Object[][] data, String[] columnNames) {
        return new DefaultTableModel(data, columnNames) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                //return column == 4 || column == 5; Alguma coluna
                return false; //Todas as colunas;
            }
        };
    }

    private void jTableMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMatriculasMouseClicked
        try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) jTableMatriculas.getModel();

            //Pega o ID selecionado:
            int matriculaId = Integer.parseInt(model.getValueAt(jTableMatriculas.getSelectedRow(), 0).toString());

            //Lista todos os dados:
            AlunoDisciplina[] alunoMatri = AlunoDisciplinaController.getDisciplinaPorMatriculaID(matriculaId);

            String[] columnNames = {"ID", "DISCIPLINA"}; //As colunas ser?o adicionadas:

            Object[][] data = new Object[alunoMatri.length][2]; //O 2, aqui, ? a quantidade de colunas

            int index = 0;

            for (AlunoDisciplina aluno_disciplina : alunoMatri) {
                data[index][0] = aluno_disciplina.getDisciplinaId(); //
                data[index][1] = aluno_disciplina.getTituloDisciplina(); //
                index++;
            }

            jTableDisciplinas.setModel(setModel(data, columnNames));

            //int nRow = model.getRowCount();
            //System.out.println();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableMatriculasMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlunoIncluirEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            TelaAlunoIncluirEditar dialog = new TelaAlunoIncluirEditar(new javax.swing.JFrame(), true, "incluir");
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
    private javax.swing.JButton jButtonExcluirAluno;
    private javax.swing.JButton jButtonMatricular;
    private javax.swing.JButton jButtonSalvarAlteracoes;
    private javax.swing.JComboBox<String> jComboBoxCurso;
    private javax.swing.JComboBox<String> jComboBoxDisciplinas;
    private javax.swing.JComboBox<String> jComboBoxResultado;
    private javax.swing.JComboBox<String> jComboBoxTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCurso_Id;
    private javax.swing.JLabel jLabelTurma_Id;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMatricula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDisciplinas;
    private javax.swing.JTable jTableMatriculas;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldDataMatricula;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMedia;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPeriodo;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
