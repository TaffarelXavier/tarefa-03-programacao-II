/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import servicos.Funcoes;
import servicos.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Curso;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 * @author Ramon Deyvid <ramon.dayvid08@gmail.com>
 */
public class CursoController extends Funcoes {

    /**
     * Inclui um novo curso
     *
     * @param tituloCurso
     * @return
     */
    public static int incluir(String tituloCurso) {
        try {
            String sql = "INSERT INTO curso (nomecurso) VALUES (?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, tituloCurso.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     *
     * @param cursoCodigo
     * @return
     */
    public static int excluirCurso(int cursoCodigo) {
        String sql = "DELETE FROM curso WHERE codcurso = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, cursoCodigo);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * @param codigoCurso
     * @param nomeCurso
     * @return
     */
    public static int atualizarCurso(
            int codigoCurso,
            String nomeCurso) {

        String sql = "UPDATE curso SET nomecurso = ? WHERE codcurso = ?;";
        PreparedStatement stm;
        try {
            stm = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, nomeCurso);
            stm.setInt(2, codigoCurso);
            return stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }

    public static void buscarCursoPorId() {

    }

    /**
     *
     * @return @throws Exception
     */
    public static Curso[] listarTudo() throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT * FROM curso;");

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Curso[] cursos = new Curso[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    cursos[i] = new Curso(rs.getString("nomecurso"), rs.getInt("codcurso"));
                    ++i;
                }

                return cursos;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public static Curso[] filtrarcCurso(String filtro, String filtroTipo) throws Exception {

        PreparedStatement preparedStatement = null;

        try {

            String sql;

            ResultSet rs = null;

            if (filtroTipo.toLowerCase().equals("nome".toLowerCase())) {
                sql = "SELECT * FROM curso WHERE nomecurso LIKE ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, "%" + filtro + "%");
            } else if (filtroTipo.toLowerCase().equals("id".toLowerCase())) {
                sql = "SELECT * FROM curso WHERE codcurso = ?;";
                preparedStatement = Conexao.conectar().prepareStatement(sql);
                preparedStatement.setString(1, filtro);

            }
            rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
            } else {

                Curso[] cursos = new Curso[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    cursos[i] = new Curso(rs.getString("nomecurso"), rs.getInt("codcurso"));
                    ++i;
                }

                return cursos;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
