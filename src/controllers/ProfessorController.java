/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Professor;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class ProfessorController {

    /**
     *
     * @param disciplina
     * @param creditos
     * @return
     */
    public static int incluir(String disciplina, String creditos) {
        try {
            String sql = "INSERT INTO disciplina (titulo, creditos) VALUES (?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, disciplina.trim());
            preparedStatement.setString(2, creditos.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param cpf
     * @param nome
     * @param status
     * @param nivel
     * @param codigoProfessor
     * @return
     */
    public static int atualizar(String cpf, String nome, String status, String nivel, int codigoProfessor) {
        try {
            String sql = "UPDATE `professor` SET `prof_cpf` = ?, `prof_nome`= ?, `prof_status` = ?,"
                    + " `prof_nivel` = ? WHERE `professor`.`prof_id` = ?;";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, cpf.trim());
            preparedStatement.setString(2, nome.trim());
            preparedStatement.setString(3, status.trim());
            preparedStatement.setString(4, nivel.trim());
            preparedStatement.setInt(5, codigoProfessor);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param professorId
     * @return
     */
    public static int excluir(int professorId) {
        try {

            String sql = "DELETE FROM professor WHERE prof_id = ?;";
            PreparedStatement prest;
            try {
                prest = Conexao.conectar().prepareStatement(sql);
                prest.setInt(1, professorId);
                prest.executeUpdate();
                Conexao.conectar().commit();
                JOptionPane.showMessageDialog(null, "The record has been deleted successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "The record has been deleted successfully.");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "The record has been deleted successfully.");
        }
        return 0;
    }

    /**
     *
     * @return @throws Exception
     */
    public static Professor[] listarTudo() throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT * FROM professor;");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Professor[] professores = new Professor[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    professores[i] = new Professor(
                            rs.getInt("prof_id"),
                            rs.getString("prof_cpf"),
                            rs.getString("prof_nome"),
                            rs.getString("prof_senha"),
                            rs.getString("prof_status"),
                            rs.getString("prof_nivel")
                    );
                    ++i;
                }

                return professores;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
