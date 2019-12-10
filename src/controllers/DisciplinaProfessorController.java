/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Curso;
import modelos.ProfessorDisciplina;
import servicos.Conexao;
import static servicos.Funcoes.getTotalDeRegistros;

/**
 *
 * @author Taffrel Xavier <taffarel_deus@hotmail.com>
 */
public class DisciplinaProfessorController {

    /**
     *
     * @param professorId
     * @param disciplinaId
     * @return
     */
    public static int incluir(int professorId, int disciplinaId) {
        try {
            String sql = "INSERT INTO professor_disciplina (discpro_professor_id, discpro_disciplina_id) VALUES (?, ?);";
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, professorId);
            preparedStatement.setInt(2, disciplinaId);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return 0;
    }

    public static int excluirDisciplinasPorProfessor(int professorId, int disciplinaId) {
        String sql = "DELETE FROM professor_disciplina WHERE discpro_professor_id = ? AND discpro_disciplina_id = ?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Conexao.conectar().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, professorId);
            preparedStatement.setInt(2, disciplinaId);
            return preparedStatement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ProfessorDisciplina[] listarDisciplinasPorProfessor(int professorId) throws Exception {

        PreparedStatement stm;

        try {

            stm = Conexao.conectar().prepareStatement("SELECT discpro_id, discpro_professor_id , prof_nome, titulo FROM `professor_disciplina` as t1 JOIN professores AS t2 on t2.prof_id = t1.discpro_professor_id JOIN disciplina AS t3 ON t1.discpro_disciplina_id = t3.coddisc WHERE discpro_professor_id = ?");
            stm.setInt(1, professorId);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                System.out.println("Nenhum registro encontrado.");
                return null;
            } else {

                ProfessorDisciplina[] professorDisciplina = new ProfessorDisciplina[getTotalDeRegistros(rs)];

                int i = 0;

                while (rs.next()) {
                    professorDisciplina[i] = new ProfessorDisciplina(rs.getInt("discpro_id"), rs.getString("titulo"));
                    ++i;
                }

                return professorDisciplina;
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
