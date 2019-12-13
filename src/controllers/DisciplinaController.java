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
import modelos.Curso;
import modelos.Disciplina;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class DisciplinaController {

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
     * @param disciplina
     * @param creditos
     * @return
     */
    public static int atualizar(String disciplina, String creditos, int disciplinaId) {
        try {
            String sql = "UPDATE `disciplina` SET `titulo` = ?, creditos =? WHERE `disciplina`.`coddisc` = ?;";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, disciplina.trim());
            preparedStatement.setString(2, creditos.trim());
            preparedStatement.setInt(3, disciplinaId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param disciplinaId
     * @return
     */
    public static int excluir(int disciplinaId) {
        try {
            String sql = "DELETE FROM disciplina WHERE coddisc =?";
            PreparedStatement prest;
            try {
                prest = Conexao.conectar().prepareStatement(sql);
                prest.setInt(1, disciplinaId);
                int result = prest.executeUpdate();
//                Conexao.conectar().commit();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível executar a operação.");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar a operação.");
        }
        return 0;
    }

    public static Disciplina[] listarTudo() throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT * FROM disciplina;");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Disciplina[] disciplinas = new Disciplina[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    disciplinas[i] = new Disciplina(rs.getInt("coddisc"), rs.getString("titulo"), rs.getString("creditos"));
                    ++i;
                }

                return disciplinas;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Disciplina[] filtrarDisciplina(String filtro, String filtroTipo) throws Exception {

        PreparedStatement preparedStatement = null;

        try {
            String sql;

            ResultSet rs = null;
            
            if (filtroTipo.toLowerCase().equals("TÍTULO".toLowerCase())) {
                sql = "SELECT * FROM disciplina WHERE titulo LIKE ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, "%" + filtro + "%");
            } else if (filtroTipo.toLowerCase().equals("ID".toLowerCase())) {
                sql = "SELECT * FROM disciplina WHERE coddisc = ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, filtro);

            }
            rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {
                Disciplina[] disciplinas = new Disciplina[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    disciplinas[i] = new Disciplina(rs.getInt("coddisc"), rs.getString("titulo"), rs.getString("creditos"));
                    ++i;
                }

                return disciplinas;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
