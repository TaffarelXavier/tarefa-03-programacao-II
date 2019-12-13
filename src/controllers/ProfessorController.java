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
import modelos.Disciplina;
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
     * @param cpf
     * @param nome
     * @param status
     * @param nivel
     * @return
     */
    public static int incluir(String cpf, String nome, String status, String nivel) {
        try {
            String sql = "INSERT INTO professores (prof_cpf, prof_nome, prof_senha, prof_status, prof_nivel) VALUES (?,?,'',?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, cpf.trim());
            preparedStatement.setString(2, nome.trim());
            preparedStatement.setString(3, status.trim());
            preparedStatement.setString(4, nivel.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 2);
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
            String sql = "UPDATE `professores` SET `prof_cpf` = ?, `prof_nome`= ?, `prof_status` = ?,"
                    + " `prof_nivel` = ? WHERE `professores`.`prof_id` = ?;";
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
     * @param professoresId
     * @return
     */
    public static int excluir(int professoresId) {
        try {

            String sql = "DELETE FROM professores WHERE prof_id = ?;";
            PreparedStatement prest;
            try {
                prest = Conexao.conectar().prepareStatement(sql);
                prest.setInt(1, professoresId);
                prest.executeUpdate();
                Conexao.conectar().commit();
                JOptionPane.showMessageDialog(null, "O registro foi excluído com sucesso!");
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

            stm = Conexao.conectar().prepareStatement("SELECT * FROM professores;");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Professor[] professoreses = new Professor[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    professoreses[i] = new Professor(
                            rs.getInt("prof_id"),
                            rs.getString("prof_cpf"),
                            rs.getString("prof_nome"),
                            rs.getString("prof_senha"),
                            rs.getString("prof_status"),
                            rs.getString("prof_nivel")
                    );
                    ++i;
                }

                return professoreses;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Professor[] filtrarDisciplina(String filtro, String filtroTipo) throws Exception {

        PreparedStatement preparedStatement = null;

        try {
            String sql;

            ResultSet rs = null;

       
            if (filtroTipo.toLowerCase().equals("NOME".toLowerCase()) || filtroTipo.toLowerCase().equals("STATUS".toLowerCase())) {
                sql = "SELECT * FROM professores WHERE prof_nome LIKE ? || prof_status LIKE ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, "%" + filtro + "%");
                preparedStatement.setString(2, "%" + filtro + "%");
            } else if (filtroTipo.toLowerCase().equals("ID".toLowerCase()) || filtroTipo.toLowerCase().equals("CPF".toLowerCase())) {
                sql = "SELECT * FROM professores WHERE prof_id = ? || prof_cpf = ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, filtro);
                preparedStatement.setString(2, filtro);

            }
            rs = preparedStatement.executeQuery();

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
