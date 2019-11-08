/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import servicos.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Curso;

/**
 *
 * @author Taffarel Xavier <taffarel_deus@hotmail.com>
 */
public class CursoController {

    /**
     * Inclui um novo curso
     *
     * @param tituloCurso
     * @return
     */
    public static int incluirCurso(String tituloCurso) {
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
    public static Curso[] listarTodosCursos() throws Exception {

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

    /**
     * <p>
     * Retorna o total de registros de uma busca.</p>
     *
     * @param rs ResultSet
     * @return Inteiro
     * @throws SQLException
     */
    public static int getTotalDeRegistros(ResultSet rs) throws SQLException {
        int total;
        rs.last();
        total = rs.getRow();
        rs.beforeFirst();
        return total;
    }
}
