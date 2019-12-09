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
     * Inclui um novo curso
     *
     * @param tituloCurso
     * @return
     */
    public static int incluirNovoAluno(String tituloCurso) {
        try {
            String sql = "INSERT INTO aluno (nomecurso) VALUES (?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1, tituloCurso.trim());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
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
                    System.out.println(rs.getString("nomealuno"));
                    alunos[i] = new Aluno(rs.getString("nomealuno"), rs.getInt("codaluno"));
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
