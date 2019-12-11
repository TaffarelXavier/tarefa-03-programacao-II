/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Aluno;
import modelos.AlunoDisciplina;
import modelos.AlunoMatricula;
import modelos.Disciplina;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class AlunoDisciplinaController {

    /**
     *
     * @param alunoFkId
     * @param disciplinaFkId
     * @param matriculaFkId
     * @return
     */
    public static int incluir(int alunoFkId, int disciplinaFkId, int matriculaFkId) {
        try {

            String sql = "INSERT INTO aluno_disciplina (aluno_fk_id, disciplina_fk_id, matricula_fk_id) VALUES (?,?,?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, alunoFkId);
            preparedStatement.setInt(2, disciplinaFkId);
            preparedStatement.setInt(3, matriculaFkId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção: erro!", 1);
        }
        return 0;
    }

    public static AlunoDisciplina[] getDisciplinaPorMatriculaID(int matriculaId) throws Exception {

        PreparedStatement preparedStatement;

        try {

            preparedStatement = Conexao.conectar().prepareStatement("SELECT * FROM aluno_disciplina AS t1\n"
                    + "JOIN disciplina AS t2 ON t1.disciplina_fk_id = t2.coddisc WHERE matricula_fk_id = ?");

            preparedStatement.setInt(1, matriculaId);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado para este aluno.");
            } else {

                AlunoDisciplina[] aluno_disciplina = new AlunoDisciplina[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {

                    aluno_disciplina[i] = new AlunoDisciplina(rs.getInt("coddisc"), rs.getString("titulo"));
                    ++i;
                }

                return aluno_disciplina;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
