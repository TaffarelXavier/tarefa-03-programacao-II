/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import servicos.Funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Aluno;
import servicos.Conexao;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class AlunoController extends Funcoes {

    /**
     * *
     *
     * @param nome
     * @param dataNascimento
     * @param cpf
     * @param telefone
     * @param email
     * @return
     */
    public static int incluir(String nome, String dataNascimento, String cpf, String telefone, String email) {
        try {
            String sql = "INSERT INTO aluno (nomealuno, data_nascimento,"
                    + " cpf, telefone, email) VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, nome.trim());
            preparedStatement.setString(2, dataNascimento.trim());
            preparedStatement.setString(3, cpf.trim());
            preparedStatement.setString(4, telefone.trim());
            preparedStatement.setString(5, email.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }
    /**
     * 
     * @param alunoId
     * @return 
     */
    public static int excluir(int alunoId) {
        String sql = "DELETE FROM aluno WHERE codaluno = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, alunoId);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
        }
        return 0;
    }

    /**
     *
     * @param nome
     * @param dataNascimento
     * @param cpf
     * @param telefone
     * @param email
     * @param alunoIDd
     * @return
     */
    public static int alterar(String nome, String dataNascimento, String cpf, String telefone, String email, int alunoIDd) {
        try {
            String sql = "UPDATE aluno SET nomealuno = ?, data_nascimento =?,"
                    + " cpf = ?, telefone =?, email=? WHERE codaluno=?";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, nome.trim());
            preparedStatement.setString(2, dataNascimento.trim());
            preparedStatement.setString(3, cpf.trim());
            preparedStatement.setString(4, telefone.trim());
            preparedStatement.setString(5, email.trim());
            preparedStatement.setInt(6, alunoIDd);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }

    public static Aluno[] listarTodos() throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT * FROM aluno;");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Aluno[] alunos = new Aluno[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    //String nomeALuno, int codigoAluno, String , String , String , String 
                    alunos[i] = new Aluno(rs.getString("nomealuno"),
                            rs.getInt("codaluno"),
                            rs.getString("data_nascimento"),
                            rs.getString("cpf"),
                            rs.getString("email"),
                            rs.getString("telefone")
                    );
                    ++i;
                }

                return alunos;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param alunoId
     * @return
     * @throws Exception
     */
    public static Aluno[] getDadosPorAlunoId(int alunoId) throws Exception {

        PreparedStatement preparedStatement;

        try {

            preparedStatement = Conexao.conectar().prepareStatement("SELECT * FROM aluno WHERE codaluno = ? LIMIT 1;");

            preparedStatement.setInt(1, alunoId);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado para alunos.");
            } else {

                Aluno[] alunos = new Aluno[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    //String nomeALuno, int codigoAluno, String , String , String , String 
                    alunos[i] = new Aluno(rs.getString("nomealuno"),
                            rs.getInt("codaluno"),
                            rs.getString("data_nascimento"),
                            rs.getString("cpf"),
                            rs.getString("email"),
                            rs.getString("telefone")
                    );
                    ++i;
                }
                return alunos;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
