/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.HeadlessException;
import servicos.Funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Turma;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class TurmaController extends Funcoes {

    /**
     *
     * @param periodLetivo
     * @param sala
     * @param turno
     * @param capacidade
     * @param bloco
     * @return
     */
    public static int incluir(String periodLetivo, String sala,
            String turno, String capacidade, String bloco) {
        try {
            String sql = "INSERT INTO turma (`periodoletivo`, `sala`, "
                    + "`turno`, `capacidade`, `bloco`) VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, periodLetivo.trim());
            preparedStatement.setString(2, sala.trim());
            preparedStatement.setString(3, turno.trim());
            preparedStatement.setString(4, capacidade.trim());
            preparedStatement.setString(5, bloco.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param sala
     * @param capacidade
     * @param turno
     * @param bloco
     * @param periodLetivo
     * @param turmaId
     * @return
     */
    public static int atualizar(String sala,
            String capacidade, String turno, String bloco, String periodLetivo, int turmaId) {
        try {
            String sql = "UPDATE `turma` SET `sala` = ?, `capacidade` = ?, `turno` =?, `bloco`= ?, `periodoletivo` = ? WHERE `codturma` = ?;";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, sala.trim());
            preparedStatement.setString(2, capacidade.trim());
            preparedStatement.setString(3, turno.trim());
            preparedStatement.setString(4, bloco.trim());
            preparedStatement.setString(5, periodLetivo.trim());
            preparedStatement.setInt(6, turmaId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro!", 1);
        }
        return 0;
    }

    /**
     *
     * @param turmaId
     * @return
     */
    public static int excluir(int turmaId) {
        try {
            Object[] options = {"Sim", "Não"};
            int n = JOptionPane.showOptionDialog(null,
                    "Deseja realmente excluir esta turma ?",
                    "Confirma?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);
            if (n == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM turma WHERE codturma = ?";
                PreparedStatement prest;
                try {
                    prest = Conexao.conectar().prepareStatement(sql);
                    prest.setInt(1, turmaId);
                    int result = prest.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
                    return result;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        return 0;
    }

    public static Turma[] listarTudo() throws Exception {

        PreparedStatement stm;

        try {
            String sqlJoin = "SELECT * FROM `turma`";

            stm = Conexao.conectar().prepareStatement(sqlJoin);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Turma[] turmas = new Turma[getTotalDeRegistros(rs)];

                int i = 0;

                //int codigoTurma, String periodLetivo, String codigoSala, String bloco, int codigoProfessor, int codigoDisciplina
                while (rs.next()) {
                    turmas[i] = new Turma(
                            rs.getInt("codturma"),
                            rs.getString("periodoletivo"),
                            rs.getString("sala"),
                            rs.getString("bloco"),
                            rs.getString("sala"),
                            rs.getInt("capacidade"),
                            rs.getString("turno"),
                            rs.getInt("ano_letivo")
                    );
                    ++i;
                }

                return turmas;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Turma[] buscarTurmaPorId(int turmaId) throws Exception {

        PreparedStatement stm;

        try {
            String sqlJoin = "SELECT * FROM `turma` WHERE codturma = ? LIMIT 1;";

            stm = Conexao.conectar().prepareStatement(sqlJoin);

            stm.setInt(1, turmaId);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Turma[] turmas = new Turma[getTotalDeRegistros(rs)];

                int i = 0;

                //int codigoTurma, String periodLetivo, String codigoSala, String bloco, int codigoProfessor, int codigoDisciplina
                while (rs.next()) {
                    turmas[i] = new Turma(
                            rs.getInt("codturma"),
                            rs.getString("periodoletivo"),
                            rs.getString("sala"),
                            rs.getString("bloco"),
                            rs.getString("sala"),
                            rs.getInt("capacidade"),
                            rs.getString("turno"),
                            rs.getInt("ano_letivo")
                    );
                    ++i;
                }
                rs.close();

                return turmas;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Turma[] filtrarTurma(String filtro, String filtroTipo) throws Exception {

        PreparedStatement preparedStatement = null;

        try {
            String sql;

            ResultSet rs = null;

            if (filtroTipo.toLowerCase().equals("SALA".toLowerCase()) || filtroTipo.toLowerCase().equals("BLOCO".toLowerCase())) {
                sql = "SELECT * FROM turma WHERE sala LIKE ? || bloco LIKE ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, "%" + filtro + "%");
                preparedStatement.setString(2, "%" + filtro + "%");
            } else if (filtroTipo.toLowerCase().equals("ID".toLowerCase()) || filtroTipo.toLowerCase().equals("CAPACIDADE".toLowerCase())) {
                sql = "SELECT * FROM turma WHERE ID = ? || CAPACIDADE = ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, filtro);
                preparedStatement.setString(2, filtro);

            }
            rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Turma[] turmas = new Turma[getTotalDeRegistros(rs)];

                int i = 0;

                //int codigoTurma, String periodLetivo, String codigoSala, String bloco, int codigoProfessor, int codigoDisciplina
                while (rs.next()) {
                    turmas[i] = new Turma(
                            rs.getInt("codturma"),
                            rs.getString("periodoletivo"),
                            rs.getString("sala"),
                            rs.getString("bloco"),
                            rs.getString("sala"),
                            rs.getInt("capacidade"),
                            rs.getString("turno"),
                            rs.getInt("ano_letivo")
                    );
                    ++i;
                }
                rs.close();

                return turmas;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
